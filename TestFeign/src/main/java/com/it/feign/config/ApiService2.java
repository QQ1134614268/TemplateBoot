package com.it.feign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "apiService2", url = "http://127.0.0.1:8080/api", name = "api2")
public interface ApiService2 {
    @GetMapping(value = "/add")
    int add(@RequestParam("a") int a, @RequestParam("b") int b);
}
