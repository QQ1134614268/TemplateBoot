package com.cloud.api;

import com.cloud.api.fallback.RemoteTrxLogFallbackFactory;
import com.cloud.base.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cloud-global-transactional", fallbackFactory = RemoteTrxLogFallbackFactory.class)
public interface RemoteTrxLogService {

    @PostMapping("/api/trxLog/part2")
    ApiResult<Boolean> part2(@RequestParam("uid") String uid);

    @PostMapping("/api/trxLog/part3")
    ApiResult<Boolean> part3(@RequestParam("uid") String uid);

    @PostMapping("/api/trxLog/part2_with_transactional")
    ApiResult<Boolean> part2_with_transactional(@RequestParam("uid") String uid);

    @PostMapping("/api/trxLog/part3_with_transactional")
    ApiResult<Boolean> part3_with_transactional(@RequestParam("uid") String uid);
}
