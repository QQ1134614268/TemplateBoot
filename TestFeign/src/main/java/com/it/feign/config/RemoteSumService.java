package com.it.feign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "remoteSumService", url = "${TestFeign.sumService.url}") // configuration fallback fallbackFactory
public interface RemoteSumService {
    @GetMapping(value = "${TestFeign.sumService.sumPath}")
    int sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2);
}
