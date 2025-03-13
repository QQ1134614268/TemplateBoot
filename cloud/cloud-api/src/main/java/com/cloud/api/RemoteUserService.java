package com.cloud.api;

import com.cloud.base.ApiResult;
import com.cloud.base.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "remoteUserService", fallbackFactory = RemoteApiServiceFallbackFactory.class) // 使用服务名称
public interface RemoteUserService {
    @PostMapping(value = "/stock/decrease")
    ApiResult<String> decrease(@RequestBody StockDto dto);
}
