package com.it.feign.controller;

import com.alibaba.fastjson2.JSON;
import com.it.feign.config.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/mock")
public class MockApi {

    @GetMapping("/sum")
    public ApiResult<Integer> sum(int num1, int num2) {
        if (num1 < 0) {
            throw new RuntimeException();
        }
        log.info("开始计算");
        return ApiResult.success(num1 + num2);
    }

    /**
     * produces: 指定返回的contentType; TEXT_PLAIN_VALUE: 默认只序列化字符串
     */
    @GetMapping(value = "/textPlain", produces = MediaType.TEXT_PLAIN_VALUE)
    public String textPlain() {
        log.info("textPlain");
        return JSON.toJSONString(ApiResult.success("textPlain"));
    }
}
