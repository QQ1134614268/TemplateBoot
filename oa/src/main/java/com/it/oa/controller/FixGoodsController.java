package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.FixGoodsDto;
import com.it.oa.controller.dto.UserDTO;
import com.it.oa.controller.para.*;
import com.it.oa.entity.*;
import com.it.oa.mapper.FixGoodsMapper;
import com.it.oa.service.EnumService;
import com.it.oa.service.FixGoodsRecordService;
import com.it.oa.service.FixGoodsService;
import com.it.oa.service.UserService;
import com.it.oa.util.DateUtil;
import com.it.oa.util.FrontUtil;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.it.oa.config.constant.FixGoodsRecordStatus.*;
import static com.it.oa.config.constant.FixGoodsStatus.*;
import static com.it.oa.config.constant.GroupCode.FIX_GOODS_TYPE;
import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "行政管理/物资管理/固定物资管理")
@RestController
@RequestMapping("/api/fixGoods")
@Slf4j
public class FixGoodsController {
    @Resource
    private FixGoodsService fixGoodsService;
    @Resource
    private FixGoodsRecordService fixGoodsRecordService;
    @Resource
    private FixGoodsMapper fixGoodsMapper;
    @Resource
    private EnumService enumService;
    @Resource
    private UserService userService;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<FixGoodsDto>> getPage(Page<FixGoodsEntity> page, FixGoodsQo qo) {
        List<EnumEntity> list = enumService.getEnum2(FIX_GOODS_TYPE);

        MPJLambdaWrapper<FixGoodsEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, FixGoodsEntity::getTypeId);
        wrapper.between(toBool(qo.getEndTime()), FixGoodsEntity::getCreateTime, qo.getStartTime(), qo.getEndTime()).like(StringUtil.toBool(qo.getSearch()), ConsumeGoodsEntity::getGoodsName, qo.getSearch()).eq(StringUtil.toBool(qo.getStatus()), FixGoodsEntity::getStatus, qo.getStatus());
        wrapper.selectAll(FixGoodsEntity.class);
        wrapper.selectAs(EnumEntity::getValue, FixGoodsDto::getTypeName);
        IPage<FixGoodsDto> ret = fixGoodsMapper.selectJoinPage(page, FixGoodsDto.class, wrapper);
        ret.getRecords().forEach(vo -> vo.setTypeIds(FrontUtil.getParentList(vo.getTypeId(), list, new ArrayList<>())));

        return ApiResult.success(ret);
    }

    @ApiOperation(value = "新增入库")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody FixGoodsEntity entity) {
        List<FixGoodsEntity> list = new ArrayList<>();
        FixGoodsEntity fixGoodsEntity;
        int num = entity.getReserveNum();
        for (int i = 0; i < num; i++) {
            fixGoodsEntity = new FixGoodsEntity();
            fixGoodsEntity.setTypeId(FrontUtil.getLast(fixGoodsEntity.getTypeIds()));
            fixGoodsEntity.setGoodsName(entity.getGoodsName());
            fixGoodsEntity.setNote(entity.getNote());
            fixGoodsEntity.setTypeId(entity.getTypeId());
            fixGoodsEntity.setManufacturer(entity.getManufacturer());
            fixGoodsEntity.setUnit(entity.getUnit());
            fixGoodsEntity.setModel(entity.getModel());
            fixGoodsEntity.setPutNote(entity.getPutNote());
            fixGoodsEntity.setStatus(FIX_GOODS_UN_USE);
            fixGoodsEntity.setReserveNum(1);
            fixGoodsEntity.setId(null);
            fixGoodsEntity.setMajorInfo(String.format("入库时间：%s", DateUtil.getCurrentDateStr()));
            list.add(fixGoodsEntity);
        }
        fixGoodsService.saveBatch(list);
        //    更新编号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        list.forEach(vo -> vo.setGoodsNumber(date + String.format("%06d", vo.getId())));
        fixGoodsService.updateBatchById(list);

        //
        FixGoodsRecordEntity recordEntity;
        for (FixGoodsEntity entity1 : list) {
            recordEntity = new FixGoodsRecordEntity();
            recordEntity.setBusinessType(FIX_GOODS_RECORD_PUT);
            recordEntity.setCreate();
            recordEntity.setNote(entity.getNote());
            recordEntity.setFixGoodsId(entity1.getId());
            fixGoodsRecordService.save(recordEntity);
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "领用/获取剩余的")
    @GetMapping("/getLeft")
    public ApiResult<List<FixGoodsEntity>> getLeft() {
        return ApiResult.success(fixGoodsService.lambdaQuery().eq(FixGoodsEntity::getStatus, FIX_GOODS_UN_USE).list());
    }

    @ApiOperation(value = "领用")
    @PostMapping("/use")
    public ApiResult<Boolean> use(@RequestBody FixUsePara para) {
        fixGoodsService.lambdaUpdate()
                .set(FixGoodsEntity::getMajorInfo, String.format("领用对象：%s;领用时间:%s", para.getLendName(), DateUtil.getCurrentDateStr()))
                .set(FixGoodsEntity::getStatus, FIX_GOODS_IN_USE)
                .set(FixGoodsEntity::getLendId, para.getLendId())
                .in(FixGoodsEntity::getId, para.getIds())
                .update();

        // 记录
        for (Integer id : para.getIds()) {
            FixGoodsRecordEntity recordEntity = new FixGoodsRecordEntity();
            recordEntity.setBusinessType(FIX_GOODS_RECORD_USE);
            recordEntity.setCreate();
            recordEntity.setLendId(para.getLendId());
            recordEntity.setLendName(para.getLendName());
            recordEntity.setNote(para.getNote());
            recordEntity.setFixGoodsId(id);
            fixGoodsRecordService.save(recordEntity);
        }

        return ApiResult.success();
    }

    @ApiOperation(value = "维修")
    @PostMapping("/repair")
    public ApiResult<Boolean> repair(@RequestBody RepairPara para) {
        fixGoodsService.lambdaUpdate()
                .set(FixGoodsEntity::getMajorInfo, String.format("维修时间：%s", DateUtil.getCurrentDateStr()))
                .set(FixGoodsEntity::getStatus, FIX_GOODS_REPAIR)
                .eq(FixGoodsEntity::getId, para.getId())
                .update();

        // 记录
        FixGoodsRecordEntity recordEntity = new FixGoodsRecordEntity();
        recordEntity.setBusinessType(FIX_GOODS_RECORD_REPAIR);
        recordEntity.setCreate();
        recordEntity.setNote(para.getNote());
        recordEntity.setFixGoodsId(para.getId());
        fixGoodsRecordService.save(recordEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "维修处理")
    @PostMapping("/repairDeal")
    public ApiResult<Boolean> repairDeal(@RequestBody RepairDealPara para) {
        // 入库
        if (Objects.equals(para.getType(), FIX_GOODS_RECORD_PUT)) {
            fixGoodsService.lambdaUpdate()
                    .set(FixGoodsEntity::getMajorInfo, String.format("入库：%s", DateUtil.getCurrentDateStr()))
                    .set(FixGoodsEntity::getStatus, FIX_GOODS_UN_USE)
                    .eq(FixGoodsEntity::getId, para.getId())
                    .update();
        } else {
            fixGoodsService.lambdaUpdate()
                    .set(FixGoodsEntity::getMajorInfo, String.format("报废：%s", DateUtil.getCurrentDateStr()))
                    .set(FixGoodsEntity::getStatus, FIX_GOODS_SCRAP)
                    .eq(FixGoodsEntity::getId, para.getId())
                    .update();
        }

        // 记录
        FixGoodsRecordEntity recordEntity = new FixGoodsRecordEntity();
        recordEntity.setBusinessType(FIX_GOODS_RECORD_REPAIR_HANDLE);
        recordEntity.setCreate();
        recordEntity.setNote(para.getNote());
        recordEntity.setFixGoodsId(para.getId());
        recordEntity.setRepairMoney(para.getRepairMoney());
        fixGoodsRecordService.save(recordEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "报废")
    @PostMapping("/scrap")
    public ApiResult<Boolean> scrap(@RequestBody RepairPara para) {
        fixGoodsService.lambdaUpdate()
                .set(FixGoodsEntity::getStatus, FIX_GOODS_SCRAP)
                .set(FixGoodsEntity::getMajorInfo, String.format("报废时间：%s", DateUtil.getCurrentDateStr()))
                .eq(FixGoodsEntity::getId, para.getId())
                .update();
        // 记录
        FixGoodsRecordEntity recordEntity = new FixGoodsRecordEntity();
        recordEntity.setBusinessType(FIX_GOODS_RECORD_SCRAP);
        recordEntity.setCreate();
        recordEntity.setNote(para.getNote());
        recordEntity.setFixGoodsId(para.getId());
        fixGoodsRecordService.save(recordEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "获取可归还对象")
    @GetMapping("/getReturnPerson")
    public ApiResult<List<UserDTO>> getReturnPerson() {
        // todo 借用人 可谓组织或人, 没有区分标识
        MPJLambdaWrapper<FixGoodsEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, FixGoodsEntity::getLendId);
        wrapper.select(UserEntity::getStaffName, UserEntity::getId);
        return ApiResult.success(fixGoodsMapper.selectJoinList(UserDTO.class, wrapper));

    }

    @ApiOperation(value = "获取归还固定物资")
    @GetMapping("/getReturnFixGoods")
    public ApiResult<List<FixGoodsEntity>> getReturnFixGoods(ReturnQo para) {
        MPJLambdaWrapper<FixGoodsEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, FixGoodsEntity::getTypeId);
        wrapper.selectAs(EnumEntity::getValue, FixGoodsEntity::getTypeName);
        return ApiResult.success(fixGoodsService.lambdaQuery().eq(FixGoodsEntity::getLendId, para.getId()).list());
    }

    @ApiOperation(value = "归还")
    @PostMapping("/toReturn")
    public ApiResult<Boolean> toReturn(@RequestBody ReturnPara para) {
        for (FixGoodsEntity fixGoodsEntity : para.getList()) {
            UserEntity user = userService.lambdaQuery().eq(UserEntity::getId, fixGoodsEntity.getLendId()).select(UserEntity::getStaffName).oneOpt().orElse(new UserEntity());
            fixGoodsService.lambdaUpdate().eq(FixGoodsEntity::getId, fixGoodsEntity.getId())
                    .set(FixGoodsEntity::getStatus, FIX_GOODS_UN_USE)
                    .set(FixGoodsEntity::getNote, fixGoodsEntity.getNote())
                    .set(FixGoodsEntity::getMajorInfo, String.format("归还对象: %s", user.getStaffName()))
                    .update();
        }

        // 记录
        FixGoodsRecordEntity recordEntity;
        for (FixGoodsEntity entity1 : para.getList()) {
            recordEntity = new FixGoodsRecordEntity();
            recordEntity.setBusinessType(FIX_GOODS_RECORD_RETURN);
            recordEntity.setCreate();
            recordEntity.setNote(para.getNote());
            recordEntity.setFixGoodsId(entity1.getId());
            fixGoodsRecordService.save(recordEntity);
        }

        return ApiResult.success();
    }

    @ApiOperation(value = "获取记录")
    @GetMapping("/getRecord")
    public ApiResult<Page<FixGoodsRecordEntity>> getRecord(Page<FixGoodsRecordEntity> page, FixGoodsQo2 qo2) {
        MPJLambdaWrapper<FixGoodsRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(FixGoodsRecordEntity::getFixGoodsId, qo2.getFixGoodsId());
        wrapper.eq(StringUtil.toBool(qo2.getBusinessType()), FixGoodsRecordEntity::getBusinessType, qo2.getBusinessType());
        wrapper.eq(StringUtil.toBool(qo2.getName()), FixGoodsRecordEntity::getLendName, qo2.getName());
        wrapper.selectAll(FixGoodsRecordEntity.class);
        Page<FixGoodsRecordEntity> ret = fixGoodsRecordService.page(page, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id编辑")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody FixGoodsEntity fixGoodsEntity) {
        fixGoodsEntity.setTypeId(FrontUtil.getLast(fixGoodsEntity.getTypeIds()));
        return ApiResult.success(fixGoodsService.updateById(fixGoodsEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(fixGoodsService.removeById(para.getId()));
    }
}