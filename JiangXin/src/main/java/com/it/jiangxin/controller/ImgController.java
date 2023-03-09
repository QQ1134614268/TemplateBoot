package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.controller.vo.IdsPara;
import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.service.ImgService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
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
    @Resource
    private EnumService enumService;

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
                .eq(imgEntity.getParentId() != null, ImgEntity::getParentId, imgEntity.getParentId())
                .eq(BoolUtils.toBool(imgEntity.getTypeId()), ImgEntity::getTypeId, imgEntity.getTypeId())
                .page(page);
        return ApiResult.success(list);
    }

    @ApiOperation(value = "获取详情")
    @GetMapping("/getInfo")
    public ApiResult<ImgEntity> getInfo(IdPara para) {
        ImgEntity e = imgService.getById(para.getId());
        if (e == null) {
            return ApiResult.fail("不存在");
        }
        List<ImgEntity> c = imgService.lambdaQuery().eq(ImgEntity::getParentId, e.getId()).list();
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
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(imgService.removeByIds(para.getIds()));
    }

    @ApiOperation(value = "获取图片树形结构")
    @PostMapping("/getImgTree")
    public ApiResult<Boolean> getImgTree(@RequestBody IdsPara para) {
        List<EnumEntity> types = enumService.lambdaQuery().eq(EnumEntity::getGroupCode, ImgTypeController.IMG_TYPE).list();
        List<ImgEntity> imgs = imgService.list();

        @Data
        class ImgTreeDto {
           String id;
           String label;
           List<ImgTreeDto> children;
        }
        // 构造树  ??
        // for()
        return ApiResult.success();
    }

}