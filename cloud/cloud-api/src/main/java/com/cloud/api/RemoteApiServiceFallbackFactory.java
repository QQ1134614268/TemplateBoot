package com.cloud.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 */
@Slf4j
@Component
public class RemoteApiServiceFallbackFactory implements FallbackFactory<RemoteApiService> {
    @Override
    public RemoteApiService create(Throwable throwable) {
        log.error("接口调用失败", throwable);
        return new RemoteApiService() {
            @Override
            public ApiResult<String> decrease(String productId, Integer count) {
                return ApiResult.fail(throwable.getMessage());
            }
        };
    }
}
