package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.controller.para.EnumParaUO;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import com.it.oa.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.it.oa.config.constant.GroupCode.MATERIAL_TYPE;


@Api(tags = "系统管理/企业设置/素材管理/分类")
@RestController
@RequestMapping("/api/enum/materialType")
@Slf4j
public class MaterialTypeController {
    private static final String groupCode = MATERIAL_TYPE;
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "添加分类")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody EnumParaPara para) {
        enumService.createOrUpdateEnum(groupCode, para);
        return ApiResult.success();
    }

    @ApiOperation(value = "获取分类,树形")
    @GetMapping("/getTree")
    public ApiResult<List<EnumEntity>> getTree() {
        List<EnumEntity> all = enumService.lambdaQuery().eq(EnumEntity::getGroupCode, groupCode).orderByAsc(EnumEntity::getSort).list();
        return ApiResult.success(TreeUtil.getTree(all));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody EnumParaUO para) {
        enumService.lambdaUpdate()
                .eq(EnumEntity::getGroupCode, groupCode)
                .eq(EnumEntity::getId, para.getId())
                .set(EnumEntity::getValue, para.getValue())
                .set(EnumEntity::getParentId, para.getParentId())
                .set(EnumEntity::getSort, para.getSort())
                .orderByAsc(EnumEntity::getSort).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        enumService.lambdaUpdate().eq(EnumEntity::getId, para.getId()).eq(EnumEntity::getGroupCode, groupCode).remove();
        return ApiResult.success();
    }
}