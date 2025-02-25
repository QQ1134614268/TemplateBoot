package com.cloud.api;

import com.cloud.base.ApiResult;
import com.cloud.base.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Feign 客户端接口是由 Spring Cloud OpenFeign 动态代理生成的，不需要显式添加 @Component
// fallbackFactory 用于指定降级处理的工厂类，实现 FallbackFactory 接口，并且是一个 Spring Bean。
@FeignClient(name = "cloud-user", fallbackFactory = RemoteApiServiceFallbackFactory.class) // 使用服务名称
public interface RemoteApiService {
    @PostMapping(value = "/stock/decrease")
    ApiResult<String> decrease(@RequestBody StockDto dto);
}
