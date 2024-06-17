package com.it.jiangxin.controller;

import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.util.FileUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Tag(name = "文件上传下载")
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Resource
    public HttpServletResponse response;
    @Value("${upload_path:}")
    private String upload_path;
    @Value("${serveHost:127.0.0.1}")
    private String serveHost;
    @Value("${server.port:}")
    private Integer servePort;

    @Operation(summary = "上传")
    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestPart("file") MultipartFile file) throws IOException {
        log.info("上传");
        // 文件类型,文件大小控制
        if (file.getSize() > 20 * 1024 * 1024) {
            return ApiResult.fail("上传文件太大");
        }
        // 启动时
        Path uploadDir = Paths.get(upload_path);
        if (!Files.isDirectory(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        String newName = FileUtil.getFileName(file.getOriginalFilename());
        // http://127.0.0.1:18080/api/file/download/xxx.img
        // https:
        // http:// 127.0.0.1/api/file/download/xxx.img
        // http:// 127.0.0.1/xxx.img
        Path path = Paths.get(upload_path, newName);

        Files.write(path, file.getBytes());
        return ApiResult.success(String.format("http://%s:%s/api/file/download/%s", serveHost, servePort, newName));
    }

    @Operation(summary = "下载")
    @GetMapping("/download/{path}")
    public ResponseEntity<Object> download(@PathVariable("path") String path) throws IOException {
        if (path == null) {
            // throw new BizException("文件不存在!");// 抛出404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Path filePath = Paths.get(upload_path, path);
        if (!Files.exists(filePath)) {
            // throw new BizException("文件不存在!"); // 抛出404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = Files.readAllBytes(filePath);
            response.reset(); // 清空response
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "max-age=2592000");
            Optional<MediaType> mediaType = MediaTypeFactory.getMediaType(path);
            response.setContentType(mediaType.orElse(MediaType.ALL).toString());
            // response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));
            outputStream.write(bytes);
        }
        return null;
    }
}
