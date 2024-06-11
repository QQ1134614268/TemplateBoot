package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.service.UserService;
import com.it.jiangxin.util.BoolUtils;
import com.it.jiangxin.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Tag(name = "系统用户")
@RestController
@RequestMapping("/api/UserController")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return ApiResult.success();
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        page = userService.lambdaQuery()
                .like(BoolUtils.toBool(userEntity.getUserName()), UserEntity::getUserName, userEntity.getUserName())
                .page(page);
        return ApiResult.success(page);
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userService.updateById(userEntity));
    }

    @Operation(summary = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(userService.removeById(id));
    }

    @Operation(summary = "login")
    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody UserEntity user) {
        user = userService.lambdaQuery()
                .eq(UserEntity::getUserName, user.getUserName())
                .eq(UserEntity::getPassword, user.getPassword())
                .one();
        if (user == null) {
            return ApiResult.fail("用户或者密码不存在");
        }
        return ApiResult.success(JwtUtil.toToken(user.getId(), user.getUserName()));
    }

    @Operation(summary = "logout")
    @PostMapping("/logout")
    public ApiResult<Boolean> logout() {
        return ApiResult.success();
    }

    @Operation(summary = "getCurrentUserInfo")
    @GetMapping("/getCurrentUserInfo")
    public ApiResult<UserEntity> getCurrentUserInfo() {
        Integer userId = JwtUtil.getUserId();
        if (userId == null) {
            return ApiResult.success();
        }
        return ApiResult.success(userService.getById(userId));
    }
}