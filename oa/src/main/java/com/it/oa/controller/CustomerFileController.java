package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.CustomerFileEntity;
import com.it.oa.service.CustomerFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "客户管理/客户列表/附件相关")
@RestController
@RequestMapping("/api/customerFile")
@Slf4j
public class CustomerFileController {
    @Resource
    private CustomerFileService customerFileService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody CustomerFileEntity customerFileEntity) {
        return ApiResult.success(customerFileService.save(customerFileEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<CustomerFileEntity>> getPage(Page<CustomerFileEntity> page, CustomerFileEntity customerFileEntity) {
        return ApiResult.success(customerFileService.page(page, new QueryWrapper<>(customerFileEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody CustomerFileEntity customerFileEntity) {
        return ApiResult.success(customerFileService.updateById(customerFileEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody DelPara para) {
        return ApiResult.success(customerFileService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(customerFileService.removeByIds(para.getIds()));
    }
}