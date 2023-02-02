package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.entity.CustomerContactEntity;
import com.it.oa.service.CustomerContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "客户管理/客户列表/客户联系人")
@RestController
@RequestMapping("/api/customerContact")
@Slf4j
public class CustomerContactController {
    @Resource
    private CustomerContactService customerContactService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody CustomerContactEntity customerContactEntity) {
        return ApiResult.success(customerContactService.save(customerContactEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<CustomerContactEntity>> getPage(Page<CustomerContactEntity> page, CustomerContactEntity customerContactEntity) {
        return ApiResult.success(customerContactService.page(page, new QueryWrapper<>(customerContactEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CustomerContactEntity customerContactEntity) {
        return ApiResult.success(customerContactService.updateById(customerContactEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(customerContactService.removeById(para.getId()));
    }

}