package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.service.ImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Api(tags = "匠心/图片")
@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImgController {
    @Resource
    private ImgService imgService;

    @ApiOperation(value = "admin/图片管理/新增")
    @PostMapping("/create")
    @Transactional
    public ApiResult<String> create(@RequestBody ImgEntity imgEntity) {
        imgService.saveOrUpdate(imgEntity);
        imgEntity.getChildren().forEach(vo -> vo.setParentId(imgEntity.getId()));
        imgService.saveOrUpdateBatch(imgEntity.getChildren());
        return ApiResult.success();
    }

    @ApiOperation(value = "admin/图片管理/修改")
    @PostMapping("/updateTree")
    public ApiResult<Boolean> updateTree(@RequestBody ImgEntity imgEntity) {
        imgService.saveOrUpdate(imgEntity);
        imgEntity.getChildren().forEach(vo -> vo.setParentId(imgEntity.getId()));
        imgService.saveOrUpdateBatch(imgEntity.getChildren());
        return ApiResult.success();
    }

    @ApiOperation(value = "首页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<ImgEntity>> getPage(Page<ImgEntity> page, ImgEntity imgEntity) {
        Page<ImgEntity> list = imgService.lambdaQuery()
                .eq(ImgEntity::getParentId, imgEntity.getParentId())
                .eq(imgEntity.getTypeId() != null, ImgEntity::getTypeId, imgEntity.getTypeId())
                .page(page);
        return ApiResult.success(list);
    }

    @ApiOperation(value = "获取详情")
    @GetMapping("/getInfo")
    public ApiResult<ImgEntity> getInfo(@RequestBody IdPara para) {
        ImgEntity e = imgService.getById(para.getId());
        List<ImgEntity> c = imgService.lambdaQuery().eq(ImgEntity::getParentId, para.getId()).list();
        e.setChildren(c);
        return ApiResult.success(e);
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(imgService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdPara para) {
        return ApiResult.success(imgService.removeByIds(para.getIds()));
    }

}