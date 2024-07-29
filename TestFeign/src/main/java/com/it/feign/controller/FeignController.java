package com.it.feign.controller;

import com.it.feign.config.ApiResult;
import com.it.feign.config.RemoteApiService;
import com.it.feign.config.RemoteHttpsService;
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

    @GetMapping("/hello")
    public ApiResult<String> hello() {
        return ApiResult.success("hello !");
    }

    @GetMapping("/testRemoteSum")
    public ApiResult<Integer> testRemoteSum() {
        // feignClient中 可以有自定义方法
        // response.sendRedirect("baidu.com"); 直接返回302, 后续方法继续执行
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
