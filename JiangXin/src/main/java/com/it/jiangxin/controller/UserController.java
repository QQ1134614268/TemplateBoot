package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "系统用户")
@RestController
@RequestMapping("/api/UserController")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page page, UserEntity userEntity) {
        return ApiResult.success(userService.page(page,new QueryWrapper<>(userEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userService.updateById(userEntity));
    }

    @ApiOperation(value = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(userService.removeById(id));
    }
}