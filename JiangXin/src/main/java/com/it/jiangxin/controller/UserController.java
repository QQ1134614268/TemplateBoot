package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.config.Log;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.service.UserService;
import com.it.jiangxin.util.BoolUtils;
import com.it.jiangxin.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;


@Tag(name = "系统用户")
@RestController
@RequestMapping("/api/UserController")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Log(title = "新增用户", type = "201")
    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Integer> create(@RequestBody UserEntity userEntity) {
        // userEntity.setPassword(PasswordUtil.desPassword(userEntity.getPassword()));
        userService.save(userEntity);
        return ApiResult.success(userEntity.getId());
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        page = userService.lambdaQuery()
                .like(BoolUtils.toBool(userEntity.getUserName()), UserEntity::getUserName, userEntity.getUserName())
                .page(page);
        return ApiResult.success(page);
    }

    @Log(title = "编辑用户", type = "202")
    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userService.updateById(userEntity));
    }

    @Log(title = "删除用户", type = "203")
    @Operation(summary = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(userService.removeById(id));
    }

    @Log(title = "登录", type = "101")
    @Operation(summary = "login")
    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody UserEntity user) {
        UserEntity old = userService.lambdaQuery().eq(UserEntity::getUserName, user.getUserName()).one();
        if (old == null) {
            return ApiResult.fail("用户或者密码不存在");
        }
        if (Objects.equals(old.getPassword(), user.getPassword())) {
            return ApiResult.success(JwtUtil.toToken(old.getId(), old.getUserName()));
        }
        return ApiResult.fail("用户或者密码不存在");
    }

    @Log(title = "退出登录", type = "102")
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