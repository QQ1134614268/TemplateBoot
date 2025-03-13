package com.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "remoteUserService", fallbackFactory = RemoteUserFallbackFactory.class) // 使用服务名称
public interface RemoteUserService {
    // @RequestMapping("/api/user/{id}")
    // public UserEntity getUser(@PathVariable("id") Integer id);
}
