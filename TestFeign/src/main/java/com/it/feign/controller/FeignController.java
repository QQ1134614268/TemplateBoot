package com.it.feign.controller;

import com.alibaba.fastjson2.JSONObject;
import com.it.feign.config.RemoteApiService;
import com.it.feign.config.RemoteHttpsService;
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
    private RemoteHttpsService remoteHttpsService;
    @Resource
    private HttpServletResponse response;

    @GetMapping("/getRemoteSum")
    public int getRemoteSum() {
        // feignClient中 可以有自定义方法
        // response.sendRedirect("baidu.com"); 直接返回302, 后续方法继续执行
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

    @GetMapping("/helloHttps")
    public String helloHttps() {
        String ret = remoteHttpsService.helloHttps();
        log.info("结果: {}", ret);
        return ret;
    }

    @GetMapping(value = "/contentType")
    public JSONObject contentType() {
        // 被重写, @RequestMapping produces参数可指定
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        return JSONObject.of("code", 1, "data", true);
    }
}
