package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ConsumeGoodsRecordDto;
import com.it.oa.controller.para.ConsumeGoodsRecordQo;
import com.it.oa.entity.ConsumeGoodsEntity;
import com.it.oa.entity.ConsumeGoodsRecordEntity;
import com.it.oa.entity.EnumEntity;
import com.it.oa.mapper.ConsumeGoodsRecordMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "行政管理/物资管理/消耗物资/物资记录")
@RestController
@RequestMapping("/api/consumeGoodsRecord")
@Slf4j
public class ConsumeGoodsRecordController {

    @Resource
    private ConsumeGoodsRecordMapper consumeGoodsRecordMapper;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ConsumeGoodsRecordDto>> getPage(Page page, ConsumeGoodsRecordQo qo) {
        MPJLambdaWrapper<ConsumeGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ConsumeGoodsEntity.class, ConsumeGoodsEntity::getId, ConsumeGoodsRecordEntity::getConsumeGoodsId);
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, ConsumeGoodsEntity::getTypeId);
        wrapper.between(toBool(qo.getStartTime()), ConsumeGoodsRecordEntity::getLendTime, qo.getStartTime(), qo.getEndTime());
        wrapper.like(toBool(qo.getSearch()), ConsumeGoodsEntity::getGoodsName, qo.getSearch());
        wrapper.eq(toBool(qo.getTypeId()), ConsumeGoodsEntity::getTypeId, qo.getTypeId());
        wrapper.select(ConsumeGoodsEntity::getGoodsName, ConsumeGoodsEntity::getModel, ConsumeGoodsEntity::getUnit);
        wrapper.selectAs(EnumEntity::getValue, ConsumeGoodsRecordDto::getTypeName);
        wrapper.select(ConsumeGoodsRecordEntity::getLendName, ConsumeGoodsRecordEntity::getChangeNum, ConsumeGoodsRecordEntity::getLendTime);
        return ApiResult.success(consumeGoodsRecordMapper.selectJoinPage(page, ConsumeGoodsRecordDto.class, wrapper));
    }
}