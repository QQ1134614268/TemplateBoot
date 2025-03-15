package com.it.feign.api.fallback;

import com.it.feign.config.ApiResult;
import com.it.feign.api.RemoteApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteApiServiceFallbackFactory implements FallbackFactory<RemoteApiService> {
    @Override
    public RemoteApiService create(Throwable throwable) {
        log.error("接口调用失败", throwable);
        return new RemoteApiService() {
            @Override
            public ApiResult<Integer> sum(int num1, int num2) {
                return ApiResult.fail(throwable.getMessage());
            }

            @Override
            public ApiResult<String> textPlain() {
                return ApiResult.fail(throwable.getMessage());
            }
        };
    }
}
