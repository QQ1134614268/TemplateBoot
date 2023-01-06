package com.it.oa.controller;

import com.it.oa.config.ApiResult;
import com.it.oa.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Api(tags = "文件上传下载")
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Resource
    private FileService fileService;

    @ApiOperation("上传")
    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestPart("file") MultipartFile file) throws IOException {
        // 文件类型,文件大小控制
        if (file.getSize() > 20 * 1024 * 1024) {
            return ApiResult.fail("上传文件太大");
        }
        // String[] types = {".img", ".png", ".jpg", ".jpeg"};
        // if (!Arrays.asList(types).contains(FileUtil.getFileType(file.getOriginalFilename()).toLowerCase())) {
        //     return ApiResult.fail("上传文件类型错误");
        // }
        return ApiResult.success(fileService.upload(file));
    }

    @ApiOperation("下载")
    @GetMapping("/download/{path}")
    public void download(@PathVariable("path") String path) throws IOException {
        fileService.download(path);
    }
}

