package com.cloud.user.controller;

import com.cloud.base.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @PostMapping("/decrease")
    public ApiResult<String> decrease(@RequestBody StockEntity entity) {
        stockService.decreaseStock(entity);
        return ApiResult.success();
    }
}