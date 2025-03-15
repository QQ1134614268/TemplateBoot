package com.it.feign.api;

import com.it.feign.api.fallback.RemoteExampleServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RemoteExampleService", url = "http://127.0.0.1:8080", fallback = RemoteExampleServiceFallback.class)
public interface RemoteExampleService {
    @GetMapping("/service404")
    int service404();
}