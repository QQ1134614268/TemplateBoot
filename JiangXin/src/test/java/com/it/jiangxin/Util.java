package com.it.jiangxin;

import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.FileController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class Util {

    @Resource
    FileController fileController;
    public String getUploadUrl(String path) throws IOException {
        org.springframework.core.io.Resource resource = new ClassPathResource(path);
        MultipartFile multipartFile = new MockMultipartFile("file", path, MediaType.TEXT_PLAIN_VALUE, resource.getInputStream());
        ApiResult<String> res = fileController.upload(multipartFile);
        if (res.isError()) {
            throw new RuntimeException(res.getMessage());
        }
        return res.getData();
    }
}
