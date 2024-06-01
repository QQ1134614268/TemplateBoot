package com.it.boot.config.file;

import com.it.boot.config.ApiResult;
import com.it.boot.config.Conf;
import com.it.boot.config.exception.BizException;
import com.it.boot.util.FileUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Tag(name = "文件上传下载")
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Resource
    public HttpServletResponse response;

    @Operation(summary = "上传")
    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestPart("file") MultipartFile file) throws IOException {
        log.info("上传");
        // 文件类型,文件大小控制
        if (file.getSize() > 20 * 1024 * 1024) {
            return ApiResult.fail("上传文件太大");
        }
        Path uploadDir = Paths.get(Conf.upload_path);
        if (!Files.isDirectory(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        String newName = FileUtil.getFileName(file.getOriginalFilename());
        Path path = Paths.get(Conf.upload_path, newName);
        Files.write(path, file.getBytes());
        return ApiResult.success(newName);
    }

    @Operation(summary = "下载")
    @GetMapping("/download/{path}")
    public void download(@PathVariable("path") String path) throws IOException {
        Path filePath = Paths.get(Conf.upload_path, path);
        if (!Files.exists(filePath)) {
            throw new BizException("文件不存在!");
        }
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = Files.readAllBytes(filePath);
            response.reset(); // 清空response
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));
            outputStream.write(bytes);
        }
    }
}
