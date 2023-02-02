package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.EnumEntity;
import com.it.oa.entity.RenewEntity;
import com.it.oa.mapper.RenewMapper;
import com.it.oa.service.RenewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "客户管理/合同管理/续费记录")
@RestController
@RequestMapping("/api/renew")
@Slf4j
public class RenewController {
    @Resource
    private RenewService renewService;
    @Resource
    private RenewMapper renewMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody RenewEntity renewEntity) {
        return ApiResult.success(renewService.save(renewEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<RenewEntity>> getPage(Page<RenewEntity> page) {
        MPJLambdaWrapper<RenewEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, RenewEntity::getTypeId);
        wrapper.selectAs(EnumEntity::getValue, RenewEntity::getTypeId);
        wrapper.selectAll(RenewEntity.class);
        IPage<RenewEntity> ret = renewMapper.selectJoinPage(page, RenewEntity.class, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody RenewEntity renewEntity) {
        return ApiResult.success(renewService.updateById(renewEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(renewService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(renewService.removeByIds(para.getIds()));
    }
}