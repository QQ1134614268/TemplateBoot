package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.controller.vo.IdsPara;
import com.it.jiangxin.controller.vo.ImgTreeDto;
import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.service.ImgService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


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
    @GetMapping("/getImgTree")
    public ApiResult<List<ImgTreeDto>> getImgTree() {
        // List<EnumEntity> types = enumService.lambdaQuery().eq(EnumEntity::getGroupCode, ImgTypeController.IMG_TYPE).list();
        // List<ImgEntity> imgs = imgService.list();

        // MPJLambdaWrapper<ConsumeGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        // wrapper.leftJoin(ConsumeGoodsEntity.class, ConsumeGoodsEntity::getId, ConsumeGoodsRecordEntity::getConsumeGoodsId);
        // wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, ConsumeGoodsEntity::getTypeId);
        // wrapper.between(toBool(qo.getStartTime()), ConsumeGoodsRecordEntity::getLendTime, qo.getStartTime(), qo.getEndTime());
        // wrapper.like(toBool(qo.getSearch()), ConsumeGoodsEntity::getGoodsName, qo.getSearch());
        // wrapper.eq(toBool(qo.getTypeId()), ConsumeGoodsEntity::getTypeId, qo.getTypeId());
        // wrapper.select(ConsumeGoodsEntity::getGoodsName, ConsumeGoodsEntity::getModel, ConsumeGoodsEntity::getUnit);
        // wrapper.selectAs(EnumEntity::getValue, ConsumeGoodsRecordDto::getTypeName);
        // wrapper.select(ConsumeGoodsRecordEntity::getLendName, ConsumeGoodsRecordEntity::getChangeNum, ConsumeGoodsRecordEntity::getLendTime);
        // return ApiResult.success(consumeGoodsRecordMapper.selectJoinPage(page, ConsumeGoodsRecordDto.class, wrapper));

        MPJLambdaWrapper<EnumEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(EnumEntity.class);
        List<ImgTreeDto> res = enumService.getBaseMapper().selectJoinList(ImgTreeDto.class, wrapper);
        List<ImgEntity> imgs = imgService.lambdaQuery().eq(ImgEntity::getParentId, 0).list();
        for (ImgTreeDto re : res) {
            List<ImgEntity> imgs1 = imgs.stream().filter(vo -> Objects.equals(vo.getTypeId(), re.getId())).collect(Collectors.toList());
            re.setImgEntityList(imgs1);
        }
        return ApiResult.success(res);
    }

}