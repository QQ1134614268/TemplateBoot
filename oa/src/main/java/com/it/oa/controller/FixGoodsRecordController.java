package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ConsumeGoodsRecordDto;
import com.it.oa.controller.para.FixGoodsRecordQo;
import com.it.oa.entity.EnumEntity;
import com.it.oa.entity.FixGoodsEntity;
import com.it.oa.entity.FixGoodsRecordEntity;
import com.it.oa.mapper.FixGoodsRecordMapper;
import com.it.oa.service.FixGoodsRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "行政管理/物资管理/固定物资/物资记录")
@RestController
@RequestMapping("/api/fixGoodsRecord")
@Slf4j
public class FixGoodsRecordController {
    @Resource
    private FixGoodsRecordService fixGoodsRecordService;

    @Resource
    private FixGoodsRecordMapper fixGoodsRecordMapper;


    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ConsumeGoodsRecordDto>> getPage(Page<FixGoodsRecordEntity> page, FixGoodsRecordQo qo) {
        MPJLambdaWrapper<FixGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(FixGoodsEntity.class, FixGoodsEntity::getId, FixGoodsRecordEntity::getFixGoodsId);
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, FixGoodsEntity::getTypeId);
        wrapper.between(toBool(qo.getStartTime()), FixGoodsRecordEntity::getCreateTime, qo.getStartTime(), qo.getEndTime());
        wrapper.eq(toBool(qo.getStatus()), FixGoodsEntity::getStatus, qo.getStatus());
        wrapper.and(toBool(qo.getSearch()), wrapper2 -> {
            wrapper2.like(FixGoodsEntity::getGoodsName, qo.getSearch()).or().like(FixGoodsEntity::getGoodsNumber, qo.getSearch());
        });
        wrapper.select(FixGoodsEntity::getGoodsName, FixGoodsEntity::getStatus, FixGoodsEntity::getCreateTime,
                FixGoodsEntity::getModel, FixGoodsEntity::getGoodsNumber, FixGoodsEntity::getUnit);
        wrapper.selectAs(EnumEntity::getValue, ConsumeGoodsRecordDto::getTypeName);
        wrapper.select(FixGoodsRecordEntity::getLendName);
        return ApiResult.success(fixGoodsRecordMapper.selectJoinPage(page, ConsumeGoodsRecordDto.class, wrapper));
    }

}