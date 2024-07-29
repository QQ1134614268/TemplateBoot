package com.it.feign.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient 的 url 支持 #{} 语法
 * GetMapping 的 value 不支持 #{} 语法
 */
// @FeignClient(name = "remoteApiService", url = "#{config.url}", configuration = {FeignTextPlainConf.class}, fallbackFactory = RemoteApiServiceFallbackFactory.class)
@FeignClient(name = "remoteApiService", url = "${TestFeign.sumService.url}", fallbackFactory = RemoteApiServiceFallbackFactory.class)
public interface RemoteApiService {

    // @GetMapping(value = "#{config.sumPath}") // 不支持#{} 语法
    @GetMapping(value = "${TestFeign.sumService.sumPath}")
    ApiResult<Integer> sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2);

    @GetMapping(value = "/api/textPlain")
    ApiResult<String> textPlain();
}
