package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.entity.TestDateEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2023-05-25 11:22
 */
@Api(tags = "测试/Cache")
@RestController
@RequestMapping("/api/TestAnnotationCacheController")
public class TestAnnotationCacheController {
    @ApiOperation("cache")
    @GetMapping("/cache")
    public ApiResult<Page<TestDateEntity>> cache() {
        // todo
        return ApiResult.success();
    }
}
