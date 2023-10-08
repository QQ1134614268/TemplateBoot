package com.it.feign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(contextId = "apiService", url = "http://127.0.0.1:9091", name = "api")
public interface ApiService {
    @GetMapping(value = "/api/TestHelloController/hello")
    String hello();
}
