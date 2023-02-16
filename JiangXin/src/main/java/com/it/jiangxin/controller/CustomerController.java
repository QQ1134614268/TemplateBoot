package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.CustomerEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "系统用户")
@RestController
@RequestMapping("/api/CustomerController")
@Slf4j
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody CustomerEntity entity) {
        customerService.save(entity);
        return ApiResult.success();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page page, CustomerEntity entity) {
        return ApiResult.success(customerService.page(page, new QueryWrapper<>(entity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CustomerEntity entity) {
        return ApiResult.success(customerService.updateById(entity));
    }

    @ApiOperation(value = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(customerService.removeById(id));
    }
}