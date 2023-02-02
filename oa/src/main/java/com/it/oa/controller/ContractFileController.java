package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.ContractFileEntity;
import com.it.oa.service.ContractFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "客户管理/合同管理/附件相关")
@RestController
@RequestMapping("/api/contractFile")
@Slf4j
public class ContractFileController {
    @Resource
    private ContractFileService contractFileService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody ContractFileEntity contractFileEntity) {
        return ApiResult.success(contractFileService.save(contractFileEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<ContractFileEntity>> getPage(Page<ContractFileEntity> page, ContractFileEntity contractFileEntity) {
        return ApiResult.success(contractFileService.page(page, new QueryWrapper<>(contractFileEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody ContractFileEntity contractFileEntity) {
        return ApiResult.success(contractFileService.updateById(contractFileEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody DelPara para) {
        return ApiResult.success(contractFileService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(contractFileService.removeByIds(para.getIds()));
    }
}