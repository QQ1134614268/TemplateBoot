package com.it.jiangxin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.FileController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

@Component
public class Util {

    @Value("${spring.profiles.active}")
    private String active;
    @Resource
    private FileController fileController;

    public String getUploadUrl(String path) throws IOException {
        ApiResult<String> res = null;
        if (Objects.equals(active, "dev")) {
            ClassPathResource resource = new ClassPathResource(path);
            MultipartFile multipartFile = new MockMultipartFile("file", path, MediaType.TEXT_PLAIN_VALUE, resource.getInputStream());
            res = fileController.upload(multipartFile);
        }
        if (Objects.equals(active, "pro")) {
            String url = "http://jiangxin.ggok.top:19200/api/file/upload";// 你的文件上传接口
            // File file = new File("D:\\dev\\config\\.pylintrc"); // 要上传的文件
            // FileSystemResource resource = new FileSystemResource(file);
            ClassPathResource resource = new ClassPathResource(path);

            // 创建 MultiValueMap 用于存储文件和其他字段
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", resource); // 添加文件
            // 如果有其他字段，可以继续添加，例如：
            // body.add("otherField", "value");

            // 创建 HttpEntity
            // 设置请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // 创建 RestTemplate 实例
            RestTemplate restTemplate = new RestTemplate();
            // 发送 POST 请求
            // String response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
            String response = restTemplate.postForObject(url, requestEntity, String.class);
            // 打印响应
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            res = objectMapper.readValue(response, new TypeReference<ApiResult<String>>() {
            });
        }

        if (res == null || res.isError()) {
            throw new RuntimeException("调用接口失败");
        }
        return res.getData();
    }
}
