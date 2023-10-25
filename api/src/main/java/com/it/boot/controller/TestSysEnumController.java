package com.it.boot.controller;

import com.it.boot.config.ApiResult;
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

/**
 * #
 * 背景, 要求(目标(从背景提取))问题, 方案 测试
 * <p>
 * ###
 * 背景, 要求(目标(从背景提取))问题, 方案 测试
 * <p>
 * ###
 * 环境:
 * 普通
 * SZ SH BJ
 * 父子(类似下拉菜单 , 类似目录, 类似多张表合并)
 * 省市县
 * 县 根据市code(最好不要id)查找,
 * 列表查询
 * 树形结构
 * 问题(目标):
 * 枚举表的结构,继承关系
 * 唯一的GroupCode
 * 每条的数据
 * 自动对应表
 * 根据code取值
 * <p>
 * code 唯一吗? 代码中不好确定唯一
 * <p>
 * 使用id主键还是code?
 * <p>
 * 方案:
 * 枚举类
 * 普通类
 * 理想约束下,code唯一, 宽松模式,code不唯一
 * 原始状态,每个分类一张表, 主键id 还是code ?? value String还是int?? 关联使用id还是code??
 * 使用groupCode 合并表, code会唯一吗 ??
 * 下拉表合并??
 * <p>
 * 转换代码,会不会太多?? 还需要吗, 自动生成, 唯一值控制
 * <p>
 * 遵从规则, ITree父子关联, 面向人(易于理解阅读), 或者转换设配ITree(ITree理想状态), 省市县如何关联, 测试
 * <p>
 * 父子,冗余设计,parentCode 与 parentId, code与id
 */
@Api(tags = "测试/用户Jpa")
@Slf4j
@RestController
@RequestMapping("/api/TestSysEnumController")
public class TestSysEnumController {

    @Resource
    private SysEnumService sysEnumService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody SysEnumEntity userEntity) {
        return ApiResult.success(sysEnumService.save(userEntity));
    }
}
