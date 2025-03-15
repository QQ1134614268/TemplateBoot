package com.it.feign.controller;

import com.it.feign.api.RemoteApiService;
import com.it.feign.api.RemoteExampleService;
import com.it.feign.api.RemoteHttpsService;
import com.it.feign.config.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/FeignController")
public class FeignController {

    @Resource
    private RemoteApiService remoteApiService;
    @Resource
    private RemoteHttpsService remoteHttpsService;
    @Resource
    private RemoteExampleService remoteExampleService;


    @GetMapping("/hello")
    public int hello() {
        int res = remoteExampleService.service404();
        System.out.println("=============" + res);
        return res;
    }


    @GetMapping("/testRemoteSum")
    public ApiResult<Integer> testRemoteSum() {
        ApiResult<Integer> ret = remoteApiService.sum(1, 2);
        log.info("计算结果: {}", ret);
        return ret;
    }

    @GetMapping("/testTextPlain")
    public ApiResult<String> testTextPlain() {
        ApiResult<String> ret = remoteApiService.textPlain();
        log.info("结果: {}", ret);
        return ret;
    }

    @GetMapping("/testHttps")
    public ApiResult<String> testHttps() {
        ApiResult<String> ret = remoteHttpsService.helloHttps();
        log.info("结果: {}", ret);
        return ret;
    }

}
