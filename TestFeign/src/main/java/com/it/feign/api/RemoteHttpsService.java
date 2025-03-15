package com.it.feign.api;

import com.it.feign.config.ApiResult;
import com.it.feign.config.FeignIgnoreHttpsConf;
import com.it.feign.api.fallback.RemoteHttpsServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "RemoteHttpsServiceClient", url = "https://localhost:443", configuration = {FeignIgnoreHttpsConf.class}, fallbackFactory = RemoteHttpsServiceFallbackFactory.class)
public interface RemoteHttpsService {
    @GetMapping(value = "/api/HelloController/helloHttps")
    ApiResult<String> helloHttps();
}
