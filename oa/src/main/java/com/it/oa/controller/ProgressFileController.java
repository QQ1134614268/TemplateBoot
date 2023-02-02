package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.ProgressFileEntity;
import com.it.oa.service.ProgressFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "客户管理/客户列表/跟进记录/附件")
@RestController
@RequestMapping("/api/progressFile")
@Slf4j
public class ProgressFileController {
    @Resource
    private ProgressFileService progressFileService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody ProgressFileEntity progressFileEntity) {
        return ApiResult.success(progressFileService.save(progressFileEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<ProgressFileEntity>> getPage(Page<ProgressFileEntity> page, ProgressFileEntity progressFileEntity) {
        return ApiResult.success(progressFileService.page(page, new QueryWrapper<>(progressFileEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody ProgressFileEntity progressFileEntity) {
        return ApiResult.success(progressFileService.updateById(progressFileEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody DelPara para) {
        return ApiResult.success(progressFileService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(progressFileService.removeByIds(para.getIds()));
    }
}