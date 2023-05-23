package com.it.boot.config.remoteapi;

import com.it.boot.config.ApiResult;
// import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient(value = "TestService")
public interface RemoteApi {
    @GetMapping({"http://localhost:9091/api/TestHelloController/name"})
    ApiResult<String> list(@RequestParam("name") String name);
}
