package com.cloud.api;

import com.cloud.api.fallback.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cloud-user", fallbackFactory = RemoteUserFallbackFactory.class) // 使用服务名称
public interface RemoteUserService {
    // @RequestMapping("/api/user/{id}")
    // public UserEntity getUser(@PathVariable("id") Integer id);
}
