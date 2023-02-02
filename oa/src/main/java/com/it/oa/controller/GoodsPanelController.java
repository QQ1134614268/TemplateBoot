package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ChangeDetailDto;
import com.it.oa.controller.dto.ChangeDto;
import com.it.oa.controller.dto.PropertyDto;
import com.it.oa.controller.dto.WarningDto;
import com.it.oa.controller.para.BasePara;
import com.it.oa.entity.*;
import com.it.oa.mapper.ConsumeGoodsMapper;
import com.it.oa.mapper.ConsumeGoodsRecordMapper;
import com.it.oa.service.ConsumeGoodsRecordService;
import com.it.oa.service.ConsumeGoodsService;
import com.it.oa.service.FixGoodsRecordService;
import com.it.oa.service.FixGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

import static com.it.oa.config.constant.ConsumeGoodsBusinessType.CONSUME_GOODS_LEND;
import static com.it.oa.config.constant.ConsumeGoodsBusinessType.CONSUME_GOODS_WAREHOUSE;
import static com.it.oa.config.constant.FixGoodsRecordStatus.*;
import static com.it.oa.config.constant.FixGoodsStatus.FIX_GOODS_SCRAP;


@Api(tags = "行政管理/物资管理/物资概览")
@RestController
@RequestMapping("/api/goodsPanel")
@Slf4j
public class GoodsPanelController {

    @Resource
    private ConsumeGoodsService consumeGoodsService;
    @Resource
    private FixGoodsService fixGoodsService;
    @Resource
    private ConsumeGoodsMapper consumeGoodsMapper;
    @Resource
    private ConsumeGoodsRecordMapper consumeGoodsRecordMapper;
    @Resource
    private FixGoodsRecordService fixGoodsRecordService;
    @Resource
    private ConsumeGoodsRecordService consumeGoodsRecordService;

    @ApiOperation(value = "资产金额1")
    @GetMapping("/getProperty")
    public ApiResult<PropertyDto> getRecord(BasePara para) {
        PropertyDto dto = new PropertyDto();
        Float num1 = consumeGoodsService.lambdaQuery()
                .between(ConsumeGoodsEntity::getCreateTime, para.getStartTime(), para.getEndTime())
                .select(ConsumeGoodsEntity::getReserveNum, ConsumeGoodsEntity::getLendNum, ConsumeGoodsEntity::getUnitPrice)
                .list()
                .stream().map(vo -> (vo.getLendNum() + vo.getReserveNum()) * vo.getUnitPrice()).reduce(Float::sum).orElse(0f);
        Float num2 = fixGoodsService.lambdaQuery()
                .between(FixGoodsEntity::getCreateTime, para.getStartTime(), para.getEndTime())
                .select(FixGoodsEntity::getReserveNum, FixGoodsEntity::getUnitPrice)
                .list()
                .stream().map(vo -> vo.getReserveNum() * vo.getUnitPrice()).reduce(Float::sum).orElse(0f);
        dto.setPurchaseAmount(num1 + num2);
        Float scrapAmount = fixGoodsService.lambdaQuery().eq(FixGoodsEntity::getStatus, FIX_GOODS_SCRAP)
                .between(FixGoodsEntity::getUpdateTime, para.getStartTime(), para.getEndTime())
                .select(FixGoodsEntity::getReserveNum, FixGoodsEntity::getUnitPrice).list()
                .stream().map(vo -> vo.getReserveNum() * vo.getUnitPrice()).reduce(Float::sum).orElse(0f);
        dto.setScrapAmount(scrapAmount);
        Float repairAmount = fixGoodsRecordService.lambdaQuery()
                .eq(FixGoodsRecordEntity::getBusinessType, FIX_GOODS_RECORD_REPAIR)
                .between(FixGoodsRecordEntity::getUpdateTime, para.getStartTime(), para.getEndTime())
                .select(FixGoodsRecordEntity::getRepairMoney).list().stream()
                .map(FixGoodsRecordEntity::getRepairMoney).reduce(Float::sum).orElse(0f);
        dto.setRepairAmount(repairAmount);
        return ApiResult.success(dto);
    }

    @ApiOperation(value = "库存预警")
    @GetMapping("/getWarning")
    public ApiResult<IPage<WarningDto>> getWarning(Page<ConsumeGoodsEntity> page, BasePara para) {
        MPJLambdaWrapper<ConsumeGoodsEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, ConsumeGoodsEntity::getTypeId);
        wrapper.eq(ConsumeGoodsEntity::getReserveNum, 0);
        wrapper.select(ConsumeGoodsEntity::getGoodsName, ConsumeGoodsEntity::getModel, ConsumeGoodsEntity::getReserveNum);
        wrapper.selectAs(EnumEntity::getValue, WarningDto::getTypeName);
        return ApiResult.success(consumeGoodsMapper.selectJoinPage(page, WarningDto.class, wrapper));
    }

    @ApiOperation(value = "物资变动情况")
    @GetMapping("/getChange")
    public ApiResult<ChangeDto> getChange(BasePara para) {
        // 消耗物资采购数量
        int num = consumeGoodsRecordService.lambdaQuery()
                .eq(ConsumeGoodsRecordEntity::getBusinessType, CONSUME_GOODS_WAREHOUSE)
                .select(ConsumeGoodsRecordEntity::getChangeNum)
                .list()
                .stream().map(ConsumeGoodsRecordEntity::getChangeNum).reduce(Integer::sum).orElse(0);
        // 固定物资采购数量
        Long num2 = fixGoodsRecordService.lambdaQuery().eq(FixGoodsRecordEntity::getBusinessType, FIX_GOODS_RECORD_PUT).count();

        // 固定物资领取次数
        Long num3 = fixGoodsRecordService.lambdaQuery().eq(FixGoodsRecordEntity::getBusinessType, FIX_GOODS_RECORD_USE).count();

        // 消耗数量
        Integer num4 = consumeGoodsRecordService.lambdaQuery()
                .eq(ConsumeGoodsRecordEntity::getBusinessType, CONSUME_GOODS_LEND)
                .select(ConsumeGoodsRecordEntity::getChangeNum)
                .list()
                .stream().map(ConsumeGoodsRecordEntity::getChangeNum).reduce(Integer::sum).orElse(0);
        // 报废数量
        Integer num5 = fixGoodsRecordService.lambdaQuery()
                .eq(FixGoodsRecordEntity::getBusinessType, FIX_GOODS_RECORD_SCRAP)
                .select(FixGoodsRecordEntity::getChangeNum)
                .list()
                .stream().map(FixGoodsRecordEntity::getChangeNum).reduce(Integer::sum).orElse(0);
        ChangeDto dto = new ChangeDto();
        dto.setPurchaseNum(num + num2.intValue());
        dto.setLendCount(num3.intValue());
        dto.setConsumeNum(num4);
        dto.setScrapNum(num5);
        return ApiResult.success(dto);
    }

    @ApiOperation(value = "物资变动明细")
    @GetMapping("/getChangeDetail")
    public ApiResult<IPage<ChangeDetailDto>> getChangeDetail(Page<ConsumeGoodsRecordEntity> page, BasePara para) {
        MPJLambdaWrapper<ConsumeGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ConsumeGoodsEntity.class, ConsumeGoodsEntity::getId, ConsumeGoodsRecordEntity::getConsumeGoodsId);
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, ConsumeGoodsEntity::getTypeId);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, ConsumeGoodsRecordEntity::getCreateBy);
        wrapper.selectAll(ConsumeGoodsRecordEntity.class);
        wrapper.select(ConsumeGoodsEntity::getGoodsName);
        wrapper.select(ConsumeGoodsEntity::getModel);
        wrapper.selectAs(UserEntity::getStaffName, ChangeDetailDto::getUpdatePersonName);
        IPage<ChangeDetailDto> ret = consumeGoodsRecordMapper.selectJoinPage(page, ChangeDetailDto.class, wrapper);
        // todo 两个表数据, 合并??
        return ApiResult.success(ret);
    }
}