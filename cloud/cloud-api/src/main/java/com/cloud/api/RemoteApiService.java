package com.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-service") // 使用服务名称, fallbackFactory = RemoteApiServiceFallbackFactory.class
public interface RemoteApiService {
    @GetMapping(value = "/stock/decrease")
    ApiResult<String> decrease(@RequestParam(name = "productId") String productId, @RequestParam(name = "count") Integer count);
}
