package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.entity.vo.ImgTreeDto;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.service.ImgService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Tag(name = "匠心/图片")
@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImgController {
    @Resource
    private ImgService imgService;
    @Resource
    private EnumService enumService;

    @Operation(summary = "admin/图片管理/新增")
    @PostMapping("/create")
    @Transactional
    public ApiResult<Integer> create(@RequestBody ImgEntity imgEntity) {
        imgService.saveOrUpdate(imgEntity);
        imgEntity.getChildren().forEach(vo -> vo.setParentId(imgEntity.getId()));
        imgService.saveOrUpdateBatch(imgEntity.getChildren());
        return ApiResult.success(imgEntity.getId());
    }

    @Operation(summary = "admin/图片管理/修改")
    @PostMapping("/updateTree")
    public ApiResult<Boolean> updateTree(@RequestBody ImgEntity imgEntity) {
        imgService.saveOrUpdate(imgEntity);
        imgEntity.getChildren().forEach(vo -> vo.setParentId(imgEntity.getId()));
        imgService.saveOrUpdateBatch(imgEntity.getChildren());
        return ApiResult.success();
    }

    @Operation(summary = "首页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<ImgEntity>> getPage(Page<ImgEntity> page, ImgEntity imgEntity) {
        Page<ImgEntity> list = imgService.lambdaQuery()
                .eq(imgEntity.getParentId() != null, ImgEntity::getParentId, imgEntity.getParentId())
                .eq(BoolUtils.toBool(imgEntity.getTypeId()), ImgEntity::getTypeId, imgEntity.getTypeId())
                .page(page);
        return ApiResult.success(list);
    }

    @Operation(summary = "获取详情")
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

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(imgService.removeById(para.getId()));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(imgService.removeByIds(para.getIds()));
    }

    @Operation(summary = "获取图片树形结构")
    @GetMapping("/getImgTree")
    public ApiResult<List<ImgTreeDto>> getImgTree() {
        MPJLambdaWrapper<SysEnumEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(SysEnumEntity::getGroupCode, "IMG-TYPE");
        wrapper.selectAll(SysEnumEntity.class);
        List<ImgTreeDto> res = enumService.getBaseMapper().selectJoinList(ImgTreeDto.class, wrapper);
        List<ImgEntity> imgs = imgService.lambdaQuery().eq(ImgEntity::getParentId, 0).list();
        for (ImgTreeDto re : res) {
            List<ImgEntity> imgs1 = imgs.stream()
                    .filter(vo -> Objects.equals(vo.getTypeId(), re.getId()))
                    .collect(Collectors.toList());
            re.setImgEntityList(imgs1);
        }
        return ApiResult.success(res);
    }

}