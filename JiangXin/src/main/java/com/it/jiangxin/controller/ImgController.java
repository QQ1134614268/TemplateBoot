package com.it.jiangxin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.entity.ImgInfoEntity;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.entity.vo.ImgDto;
import com.it.jiangxin.service.ImgInfoService;
import com.it.jiangxin.service.ImgService;
import com.it.jiangxin.service.SysEnumService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;


@Tag(name = "匠心/图片")
@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImgController {
    @Resource
    private ImgService imgService;
    @Resource
    private ImgInfoService imgInfoService;
    @Resource
    private SysEnumService sysEnumService;

    @Operation(summary = "admin/图片管理/新增")
    @PostMapping("/create")
    @Transactional
    public ApiResult<Integer> create(@RequestBody ImgEntity imgEntity) {
        imgEntity.setCreate();
        imgService.save(imgEntity);
        imgEntity.getChildren().forEach(v -> v.setImgId(imgEntity.getId()));
        imgInfoService.saveBatch(imgEntity.getChildren());
        return ApiResult.success(imgEntity.getId());
    }

    @Operation(summary = "首页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ImgDto>> getPage(Page<ImgEntity> page, ImgEntity imgEntity) {
        MPJLambdaWrapper<ImgEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(BoolUtils.toBool(imgEntity.getStyleId()), ImgEntity::getStyleId, imgEntity.getStyleId())
                .like(BoolUtils.toBool(imgEntity.getName()), ImgEntity::getName, imgEntity.getName());
        wrapper.selectAll(ImgEntity.class);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, ImgEntity::getCreateBy);
        wrapper.leftJoin(SysEnumEntity.class, SysEnumEntity::getId, ImgEntity::getStyleId);
        wrapper.selectAs(UserEntity::getAvatar, ImgDto::getUserAvtar);
        wrapper.selectAs(UserEntity::getUserName, ImgDto::getUserName);
        wrapper.selectAs(UserEntity::getNickName, ImgDto::getNickName);
        wrapper.selectAs(SysEnumEntity::getName, ImgDto::getStyleName);
        return ApiResult.success(imgService.getBaseMapper().selectJoinPage(page, ImgDto.class, wrapper));
    }

    @Operation(summary = "获取详情")
    @GetMapping("/getInfo")
    public ApiResult<ImgEntity> getInfo(IdPara para) {
        ImgEntity e = imgService.getById(para.getId());
        e.setChildren(imgInfoService.lambdaQuery().eq(ImgInfoEntity::getImgId, para.getId()).list());
        return ApiResult.success(e);
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        boolean b = imgService.removeById(para.getId());
        boolean b1 = imgInfoService.lambdaUpdate().eq(ImgInfoEntity::getImgId, para.getId()).remove();
        return ApiResult.success(b && b1);
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        boolean b = imgService.removeByIds(para.getIds());
        boolean b1 = imgInfoService.lambdaUpdate().in(ImgInfoEntity::getImgId, para.getIds()).remove();
        return ApiResult.success(b && b1);
    }

    @Operation(summary = "admin/图片管理/修改")
    @PostMapping("/update")
    @Transactional
    public ApiResult<Integer> update(@RequestBody ImgEntity entity) {
        imgService.updateById(entity);
        entity.getChildren().forEach(v -> v.setImgId(entity.getId()));
        imgInfoService.saveOrUpdateBatch(entity.getChildren());
        return ApiResult.success();
    }
}