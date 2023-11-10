package com.it.feign.controller;

import com.it.feign.config.ApiService;
import com.it.feign.config.ApiService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/FeignController")
public class FeignController {

    @Resource
    ApiService apiService;

    @Resource
    ApiService2 apiService2;

    @GetMapping("/test")
    public String test() {
        System.out.println(apiService.hello());
        return "ok";
    }

    @GetMapping("/test2")
    public String test2() {
        System.out.println(apiService2.add(1, 2));
        return "ok";
    }
}
