package com.it.feign.config;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// configuration fallback fallbackFactory
@FeignClient(name = "remoteApiService", url = "${TestFeign.sumService.url}", configuration = FeignTextPlainConf.class)
public interface RemoteApiService {
    @GetMapping(value = "${TestFeign.sumService.sumPath}")
    int sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2);

    @GetMapping(value = "/api/textPlain")
    JSONObject textPlain();
}
