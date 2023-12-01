package com.it.feign.controller;

import com.alibaba.fastjson2.JSONObject;
import com.it.feign.config.RemoteApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/FeignController")
public class FeignController {

    @Resource
    private RemoteApiService remoteApiService;
    @Resource
    private HttpServletResponse response;

    @GetMapping("/getRemoteSum")
    public int getRemoteSum() {
        int ret = remoteApiService.sum(1, 2);
        log.info("计算结果: {}", ret);
        return ret;
    }

    @GetMapping("/getRemoteTextPlain")
    public JSONObject getRemoteTextPlain() {
        JSONObject ret = remoteApiService.textPlain();
        log.info("计算结果: {}", ret);
        return ret;
    }

    @GetMapping(value = "/contentType")
    public JSONObject contentType() {
        // 被重写, @RequestMapping produces参数可指定
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        return JSONObject.of("code", 1, "data", true);
    }
}
