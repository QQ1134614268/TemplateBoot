package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.service.InviteService;
import com.it.oa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "个人办公/我的企业")
@RestController
@RequestMapping("/api/myCompany")
@Slf4j
public class MyCompanyController {

    @Resource
    private UserService userService;
    @Resource
    private InviteService inviteService;

    @ApiOperation(value = "获取入住企业")
    @GetMapping("/getEnterprise")
    public ApiResult<Boolean> enterprise() {
        return ApiResult.success();
    }

    @ApiOperation(value = "切换企业")
    @PostMapping("/changeEnt")
    public ApiResult<Boolean> changeEnt() {
        return ApiResult.success();
    }

    @ApiOperation(value = "企业邀请")
    @GetMapping("/getInvite")
    public ApiResult<Boolean> getInvite() {
        return ApiResult.success();
    }

    @ApiOperation(value = "是否同意加入企业")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById() {
        return ApiResult.success();
    }
}