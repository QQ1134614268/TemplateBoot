package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.config.enum1.DelTypeEnum;
import com.it.boot.entity.SysEnumEntity;
import com.it.boot.service.SysEnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/** todo 枚举 整理
 * 场景：
 *      1. 深交所 SZ 上交所 SH 北交所BJ
 *      2. 下拉菜单 性别,国籍
 *      4. 目录， 树形结构
 *      4. 省市县
 * 父级id,还是code
 */
@Api(tags = "测试/枚举")
@Slf4j
@RestController
@RequestMapping("/api/TestSysEnumController")
public class TestSysEnumController {

    @Resource
    private SysEnumService sysEnumService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody SysEnumEntity sysEnumEntity) {
        return ApiResult.success(sysEnumService.save(sysEnumEntity));
    }
}
