package com.it.feign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "remoteHttpsService", url = "https://localhost:443", configuration = {FeignIgnoreHttpsConf.class}, fallbackFactory = RemoteHttpsServiceFallbackFactory.class)
public interface RemoteHttpsService {
    @GetMapping(value = "/api/HelloController/helloHttps")
    ApiResult<String> helloHttps();
}
