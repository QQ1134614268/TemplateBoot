package com.cloud.api.fallback;

import com.cloud.api.RemoteTrxLogService;
import com.cloud.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteTrxLogFallbackFactory implements FallbackFactory<RemoteTrxLogService> {
    @Override
    public RemoteTrxLogService create(Throwable throwable) {
        log.error("接口调用失败", throwable);
        return new RemoteTrxLogService() {
            @Override
            public ApiResult<Boolean> part2(String uid) {
                return ApiResult.fail("接口调用失败");
            }

            @Override
            public ApiResult<Boolean> part3(String uid) {
                return ApiResult.fail("接口调用失败");
            }

            @Override
            public ApiResult<Boolean> part2_with_transactional(String uid) {
                return ApiResult.fail("接口调用失败");
            }

            @Override
            public ApiResult<Boolean> part3_with_transactional(String uid) {
                return ApiResult.fail("接口调用失败");
            }
        };
    }
}
