package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.CustomerEntity;
import com.it.jiangxin.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Tag(name = "系统用户")
@RestController
@RequestMapping("/api/CustomerController")
@Slf4j
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody CustomerEntity entity) {
        customerService.save(entity);
        return ApiResult.success();
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<CustomerEntity>> getPage(Page<CustomerEntity> page, CustomerEntity entity) {
        return ApiResult.success(customerService.page(page, new QueryWrapper<>(entity)));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CustomerEntity entity) {
        return ApiResult.success(customerService.updateById(entity));
    }

    @Operation(summary = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(customerService.removeById(id));
    }
}