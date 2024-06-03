package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Hidden
@RestController
@RequestMapping("/api/SysEnumController")
@Slf4j
public class SysEnumController {
    @Resource
    private EnumService enumService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Integer> create(@RequestBody SysEnumEntity enumEntity) {
        boolean save = enumService.save(enumEntity);
        return ApiResult.success(enumEntity.getId());
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<SysEnumEntity>> getPage(Page<SysEnumEntity> page, SysEnumEntity enumEntity) {
        Page<SysEnumEntity> enumPage = enumService.lambdaQuery()
                .eq(BoolUtils.toBool(enumEntity.getId()), SysEnumEntity::getId, enumEntity.getId())
                .eq(BoolUtils.toBool(enumEntity.getParentId()), SysEnumEntity::getParentId, enumEntity.getParentId())
                .eq(BoolUtils.toBool(enumEntity.getGroupCode()), SysEnumEntity::getGroupCode, enumEntity.getGroupCode())
                .eq(BoolUtils.toBool(enumEntity.getUniCode()), SysEnumEntity::getUniCode, enumEntity.getUniCode())
                .eq(BoolUtils.toBool(enumEntity.getStatus()), SysEnumEntity::getStatus, enumEntity.getStatus())
                .like(BoolUtils.toBool(enumEntity.getName()), SysEnumEntity::getName, enumEntity.getName())
                .page(page);
        return ApiResult.success(enumPage);
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody SysEnumEntity enumEntity) {
        return ApiResult.success(enumService.updateById(enumEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(enumService.removeByIds(para.getIds()));
    }
}