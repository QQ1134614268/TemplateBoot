package com.it.feign.config;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class MockApi {

    @GetMapping("/sum")
    public int sum(int num1, int num2) {
        log.info("开始计算");
        return num1 + num2;
    }


    @GetMapping(value = "/textPlain", produces = MediaType.TEXT_PLAIN_VALUE) // TEXT_PLAIN_VALUE 返回对象报错
    public String textPlain() {
        log.info("textPlain");
        return JSONObject.of("code", 1, "data", true).toJSONString();
    }
}
