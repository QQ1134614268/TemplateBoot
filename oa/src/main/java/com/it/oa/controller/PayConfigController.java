package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.entity.PayConfigEntity;
import com.it.oa.service.PayConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 或者枚举表 key value status(open|close)
@Api(tags = "财务管理/财务设置/支付方式")
@RestController
@RequestMapping("/api/payConfig")
@Slf4j
public class PayConfigController {
    @Resource
    private PayConfigService payConfigService;

    @ApiOperation(value = "获取")
    @GetMapping("/getPayType")
    public ApiResult<List<PayConfigEntity>> getPayType() {
        return ApiResult.success(payConfigService.list());
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updatePayType")
    public ApiResult<Boolean> updatePayType(@RequestBody PayConfigEntity entity) {
        payConfigService.updateById(entity);
        return ApiResult.success();
    }
}