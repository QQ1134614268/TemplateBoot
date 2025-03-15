package com.it.feign.api.fallback;

import com.it.feign.api.RemoteExampleService;
import org.springframework.stereotype.Component;

@Component
public class RemoteExampleServiceFallback implements RemoteExampleService {

    @Override
    public int service404() {
        return -1;
    }
}