package com.it.feign.api;

import com.it.feign.api.fallback.RemoteApiServiceFallbackFactory;
import com.it.feign.config.ApiResult;
import com.it.feign.config.FeignTextPlainConf;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RemoteApiServiceClient", url = "${TestFeign.sumService.url}", configuration = {FeignTextPlainConf.class}, fallbackFactory = RemoteApiServiceFallbackFactory.class)
public interface RemoteApiService {

    @GetMapping(value = "${TestFeign.sumService.sumPath}")
        // 支持${} 表达式, 不支持#{} 表达式
    ApiResult<Integer> sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2);

    @GetMapping(value = "/api/mock/textPlain")
    ApiResult<String> textPlain();

    default ApiResult<Integer> plus(@RequestParam("num1") int num1) {
        return ApiResult.success(num1);
    }
}
