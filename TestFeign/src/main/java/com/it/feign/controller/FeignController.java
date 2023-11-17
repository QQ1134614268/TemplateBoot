package com.it.feign.controller;

import com.it.feign.config.RemoteSumService;
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
    private RemoteSumService remoteSumService;

    @GetMapping("/getRemoteSum")
    public int getRemoteSum() {
        int ret = remoteSumService.sum(1, 2);
        log.info("计算结果: {}", ret);
        return ret;
    }
}
