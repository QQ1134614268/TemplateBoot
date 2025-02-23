package com.cloud.api;

import com.cloud.base.ApiResult;
import com.cloud.base.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "cloud-user", fallbackFactory = RemoteApiServiceFallbackFactory.class) // 使用服务名称
public interface RemoteApiService {
    @PostMapping(value = "/stock/decrease")
    ApiResult<String> decrease(@RequestBody StockDto dto);
}
