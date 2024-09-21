package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.entity.vo.SysEnumQo;
import com.it.jiangxin.service.SysEnumService;
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
    private SysEnumService sysEnumService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Integer> create(@RequestBody SysEnumEntity enumEntity) {
        boolean save = sysEnumService.saveOrUpdate(enumEntity);
        return ApiResult.success(enumEntity.getId());
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<SysEnumEntity>> getPage(Page<SysEnumEntity> page, SysEnumQo qo) {
        Page<SysEnumEntity> enumPage = sysEnumService.lambdaQuery()
                .eq(BoolUtils.toBool(qo.getId()), SysEnumEntity::getId, qo.getId())
                .eq(BoolUtils.toBool(qo.getParentId()), SysEnumEntity::getParentId, qo.getParentId())
                .eq(BoolUtils.toBool(qo.getGroupCode()), SysEnumEntity::getGroupCode, qo.getGroupCode())
                .eq(BoolUtils.toBool(qo.getUniCode()), SysEnumEntity::getUniCode, qo.getUniCode())
                .eq(BoolUtils.toBool(qo.getStatus()), SysEnumEntity::getStatus, qo.getStatus())
                .like(BoolUtils.toBool(qo.getName()), SysEnumEntity::getName, qo.getName())
                .like(BoolUtils.toBool(qo.getName()), SysEnumEntity::getName, qo.getName())
                .ge(BoolUtils.toBool(qo.getStartTime()), SysEnumEntity::getCreateTime, qo.getStartTime())
                .le(BoolUtils.toBool(qo.getEndTime()), SysEnumEntity::getCreateTime, qo.getEndTime())
                .page(page);
        return ApiResult.success(enumPage);
    }


    @Deprecated// todo 前端通过list查询
    @Operation(summary = "分页查询")
    @GetMapping("/getById")
    public ApiResult<SysEnumEntity> getById(Integer id) {
        SysEnumQo qo = new SysEnumQo();
        qo.setId(id);
        SysEnumEntity res = getPage(Page.of(1, 1), qo).getData().getRecords().stream().findFirst().orElse(null);
        return ApiResult.success(res);
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody SysEnumEntity enumEntity) {
        return ApiResult.success(sysEnumService.updateById(enumEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(sysEnumService.removeById(para.getId()));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(sysEnumService.removeByIds(para.getIds()));
    }
}