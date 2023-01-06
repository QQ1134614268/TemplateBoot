package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.SystemUserEntity;
import com.it.oa.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "系统用户")
@RestController
@RequestMapping("/api/systemUser")
@Slf4j
public class SystemUserController {
    @Resource
    private SystemUserService systemUserService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody SystemUserEntity systemUserEntity) {
        return ApiResult.success(systemUserService.save(systemUserEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<SystemUserEntity>> getPage(Page<SystemUserEntity> page, SystemUserEntity systemUserEntity) {
        return ApiResult.success(systemUserService.page(page, new QueryWrapper<>(systemUserEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody SystemUserEntity systemUserEntity) {
        return ApiResult.success(systemUserService.updateById(systemUserEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody DelPara para) {
        return ApiResult.success(systemUserService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(systemUserService.removeByIds(para.getIds()));
    }
}