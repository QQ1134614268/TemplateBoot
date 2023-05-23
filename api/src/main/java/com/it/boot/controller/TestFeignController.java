package com.it.boot.controller;


import com.it.boot.config.ApiResult;
import com.it.boot.config.exception.BizException;
import com.it.boot.config.remoteapi.RemoteApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@Api(tags = "测试/hello")
@RestController
@RequestMapping("/api/TestFeignController")
public class TestFeignController {

    // @Resource
    RemoteApi remoteApi;

    @GetMapping("/hello")
    @ApiOperation("/hello")
    public ApiResult<String> hello() {
        ApiResult<String> res = remoteApi.list("tom");
        if(res.isError()){
            throw new BizException("接口调用异常");
        }
        log.info(res.getData());
        return res;
    }
}
