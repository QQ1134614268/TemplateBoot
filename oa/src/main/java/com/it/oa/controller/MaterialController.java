package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.controller.para.MaterialQO;
import com.it.oa.controller.para.MoveImgVO;
import com.it.oa.entity.MaterialEntity;
import com.it.oa.service.MaterialService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "系统管理/企业设置/素材管理")
@RestController
@RequestMapping("/api/material")
@Slf4j
public class MaterialController {
    @Resource
    private MaterialService materialService;

    @ApiOperation(value = "上传")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody MaterialEntity materialEntity) {
        return ApiResult.success(materialService.save(materialEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<MaterialEntity>> getPage(Page<MaterialEntity> page, MaterialQO qo) {
        return ApiResult.success(
                materialService.lambdaQuery().like(StringUtil.toBool(qo.getSearch()), MaterialEntity::getImgName, qo.getSearch())
                        .eq(StringUtil.toBool(qo.getParentId()), MaterialEntity::getParentId, qo.getParentId()).page(page)
        );
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody MaterialEntity materialEntity) {
        return ApiResult.success(materialService.updateById(materialEntity));
    }

    @ApiOperation(value = "批量移动图片")
    @PostMapping("/moveImg")
    public ApiResult<Boolean> moveImg(@RequestBody MoveImgVO vo) {
        materialService.lambdaUpdate().in(MaterialEntity::getId, vo.getIds()).set(MaterialEntity::getParentId, vo.getParentId()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(materialService.removeByIds(para.getIds()));
    }
}