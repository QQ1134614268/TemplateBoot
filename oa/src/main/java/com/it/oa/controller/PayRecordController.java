package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.PayRecordEntity;
import com.it.oa.service.PayRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "客户管理/合同管理/付款记录")
@RestController
@RequestMapping("/api/payRecord")
@Slf4j
public class PayRecordController {
    public static class CheckStatus {
        public static final String 待审核 = "待审核";
        public static final String 已通过 = "已通过";
    }

    @Resource
    private PayRecordService payRecordService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody PayRecordEntity payRecordEntity) {
        payRecordEntity.setCreate();
        payRecordEntity.setCheckStatus(CheckStatus.待审核);
        return ApiResult.success(payRecordService.save(payRecordEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<PayRecordEntity>> getPage(Page<PayRecordEntity> page, PayRecordEntity payRecordEntity) {
        return ApiResult.success(payRecordService.page(page, new QueryWrapper<>(payRecordEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PayRecordEntity payRecordEntity) {
        return ApiResult.success(payRecordService.updateById(payRecordEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(payRecordService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(payRecordService.removeByIds(para.getIds()));
    }
}