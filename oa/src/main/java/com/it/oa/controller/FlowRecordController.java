package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.entity.FlowEntity;
import com.it.oa.entity.FlowRecordEntity;
import com.it.oa.service.FlowRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/办公审批/审批记录")
@RestController
@RequestMapping("/api/flowRecord")
@Slf4j
public class FlowRecordController {
    @Resource
    private FlowRecordService flowRecordService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody FlowRecordEntity flowRecordEntity) {
        return ApiResult.success(flowRecordService.save(flowRecordEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<FlowRecordEntity>> getPage(Page<FlowRecordEntity> page, FlowRecordEntity flowRecordEntity) {
        return ApiResult.success(flowRecordService.page(page, new QueryWrapper<>(flowRecordEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody FlowRecordEntity flowRecordEntity) {
        return ApiResult.success(flowRecordService.updateById(flowRecordEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody DelPara para) {
        return ApiResult.success(flowRecordService.removeById(para.getId()));
    }

    @ApiOperation(value = "同意")
    @PostMapping("/agree")
    public ApiResult<Boolean> agree(@RequestBody FlowEntity flowEntity) {
        return ApiResult.success();
    }

    @ApiOperation(value = "驳回")
    @PostMapping("/pre")
    public ApiResult<Boolean> pre(@RequestBody FlowEntity flowEntity) {
        return ApiResult.success();
    }
}