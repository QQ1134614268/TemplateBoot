package com.cloud.api;

import com.cloud.base.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "remoteTrxLogService", fallbackFactory = RemoteTrxLogFallbackFactory.class) // 使用服务名称
public interface RemoteTrxLogService {

    @PostMapping("/api/trxLog/part2")
    ApiResult<Boolean> part2(@RequestParam("uid") String uid);

    @PostMapping("/api/trxLog/part3")
    ApiResult<Boolean> part3(@RequestParam("uid") String uid);
}
