package com.it.feign.api.fallback;

import com.it.feign.config.ApiResult;
import com.it.feign.api.RemoteHttpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteHttpsServiceFallbackFactory implements FallbackFactory<RemoteHttpsService> {
    @Override
    public RemoteHttpsService create(Throwable throwable) {
        log.error("接口调用失败", throwable);
        return new RemoteHttpsService() {
            @Override
            public ApiResult<String> helloHttps() {
                return null;
            }
        };
    }
}
