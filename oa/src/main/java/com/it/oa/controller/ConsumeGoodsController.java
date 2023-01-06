package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ConsumeGoodsDto;
import com.it.oa.controller.para.*;
import com.it.oa.entity.ConsumeGoodsEntity;
import com.it.oa.entity.ConsumeGoodsRecordEntity;
import com.it.oa.entity.EnumEntity;
import com.it.oa.mapper.ConsumeGoodsMapper;
import com.it.oa.service.ConsumeGoodsRecordService;
import com.it.oa.service.ConsumeGoodsService;
import com.it.oa.service.EnumService;
import com.it.oa.util.FrontUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.it.oa.config.constant.ConsumeGoodsBusinessType.CONSUME_GOODS_LEND;
import static com.it.oa.config.constant.GroupCode.CONSUME_GOODS_TYPE;
import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "行政管理/物资管理/消耗物资管理")
@RestController
@RequestMapping("/api/consumeGoods")
@Slf4j
public class ConsumeGoodsController {

    @Resource
    private ConsumeGoodsService consumeGoodsService;
    @Resource
    private ConsumeGoodsMapper consumeGoodsMapper;
    @Resource
    private ConsumeGoodsRecordService consumeGoodsRecordService;
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ConsumeGoodsDto>> getPage(Page<ConsumeGoodsEntity> page, ConsumeGoodsQo qo) {
        List<EnumEntity> list = enumService.getEnum2(CONSUME_GOODS_TYPE);

        MPJLambdaWrapper<ConsumeGoodsEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, ConsumeGoodsEntity::getTypeId);
        wrapper.between(toBool(qo.getEndTime()), ConsumeGoodsEntity::getCreateTime, qo.getStartTime(), qo.getEndTime()).like(toBool(qo.getSearch()), ConsumeGoodsEntity::getGoodsName, qo.getSearch()).eq(toBool(qo.getTypeId()), ConsumeGoodsEntity::getTypeId, qo.getTypeId());
        wrapper.selectAll(ConsumeGoodsEntity.class);
        wrapper.selectAs(EnumEntity::getValue, ConsumeGoodsDto::getTypeName);
        IPage<ConsumeGoodsDto> ret = consumeGoodsMapper.selectJoinPage(page, ConsumeGoodsDto.class, wrapper);
        ret.getRecords().forEach(vo -> vo.setTypeIds(FrontUtil.getParentList(vo.getTypeId(), list, new ArrayList<>())));
        return ApiResult.success(ret);
    }


    @ApiOperation(value = "新增入库")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody ConsumeGoodsEntity consumeGoodsEntity) {

        consumeGoodsEntity.setTypeId(FrontUtil.getLast(consumeGoodsEntity.getTypeIds()));
        LambdaQueryWrapper<ConsumeGoodsEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ConsumeGoodsEntity::getId, consumeGoodsEntity.getId());
        wrapper.eq(ConsumeGoodsEntity::getGoodsName, consumeGoodsEntity.getGoodsName());
        wrapper.eq(ConsumeGoodsEntity::getTypeId, consumeGoodsEntity.getTypeId());
        wrapper.eq(ConsumeGoodsEntity::getModel, consumeGoodsEntity.getModel());
        wrapper.eq(ConsumeGoodsEntity::getUnit, consumeGoodsEntity.getUnit());
        wrapper.eq(ConsumeGoodsEntity::getNote, consumeGoodsEntity.getNote());
        wrapper.eq(ConsumeGoodsEntity::getManufacturer, consumeGoodsEntity.getManufacturer());
        ConsumeGoodsEntity db = consumeGoodsService.getOne(wrapper);
        if (db != null) {
            db.setReserveNum(db.getReserveNum() + consumeGoodsEntity.getReserveNum());
            consumeGoodsService.updateById(db);
        } else {
            consumeGoodsEntity.setId(null);
            consumeGoodsService.save(consumeGoodsEntity);
        }
        consumeGoodsRecordService.saveRecord2(consumeGoodsEntity);

        return ApiResult.success();
    }


    @ApiOperation(value = "领用")
    @PostMapping("/use")
    public ApiResult<Boolean> use(@RequestBody ConsumeGoodsUo uo) {
        ArrayList<ConsumeGoodsEntity> goodsList = new ArrayList<>();

        for (ConsumeGoodsUo2 vo : uo.getGoodsList()) {
            ConsumeGoodsEntity db = consumeGoodsService.getById(vo.getConsumeGoodsId());
            int num = db.getReserveNum() - vo.getLendNum();
            if (num < 0) {
                return ApiResult.fail("库存不足");
            }
            db.setReserveNum(num);
            db.setLendNum(db.getLendNum() + vo.getLendNum());
            goodsList.add(db);
        }
        consumeGoodsService.updateBatchById(goodsList);
        //  记录
        ConsumeGoodsRecordEntity entity;
        ArrayList<ConsumeGoodsRecordEntity> recordList = new ArrayList<>();
        for (ConsumeGoodsUo2 vo : uo.getGoodsList()) {
            entity = new ConsumeGoodsRecordEntity();
            entity.setBusinessType(CONSUME_GOODS_LEND);
            entity.setMajorInfo(String.format("领取对象：%s", uo.getLendName()));
            entity.setChangeNum(vo.getLendNum());
            entity.setCreate();
            entity.setNote(uo.getNote());
            recordList.add(entity);
        }
        consumeGoodsRecordService.saveBatch(recordList);
        return ApiResult.success();
    }

    @ApiOperation(value = "获取记录")
    @GetMapping("/getRecord")
    public ApiResult<Page<ConsumeGoodsRecordEntity>> getRecord(Page<ConsumeGoodsRecordEntity> page, ConsumeGoodsQo2 uo) {
        MPJLambdaWrapper<ConsumeGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(ConsumeGoodsRecordEntity::getConsumeGoodsId, uo.getConsumeGoodsId());
        wrapper.eq(toBool(uo.getName()), ConsumeGoodsRecordEntity::getLendName, uo.getName());
        wrapper.eq(toBool(uo.getBusinessType()), ConsumeGoodsRecordEntity::getBusinessType, uo.getBusinessType());
        wrapper.selectAll(ConsumeGoodsRecordEntity.class);
        Page<ConsumeGoodsRecordEntity> ret = consumeGoodsRecordService.page(page, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "补货")
    @PostMapping("/purchaseMore")
    public ApiResult<Boolean> purchaseMore(@RequestBody ConsumeGoodsEntity consumeGoodsEntity) {
        ConsumeGoodsEntity db = consumeGoodsService.getById(consumeGoodsEntity.getId());
        db.setReserveNum(db.getReserveNum() + consumeGoodsEntity.getReserveNum());
        consumeGoodsService.updateById(db);

        consumeGoodsRecordService.saveRecord(consumeGoodsEntity);

        // 记录
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id编辑")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody ConsumeGoodsEntity consumeGoodsEntity) {
        consumeGoodsEntity.setTypeId(FrontUtil.getLast(consumeGoodsEntity.getTypeIds()));
        return ApiResult.success(consumeGoodsService.updateById(consumeGoodsEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(consumeGoodsService.removeById(para.getId()));
    }

}