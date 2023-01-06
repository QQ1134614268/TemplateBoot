package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.BillDto;
import com.it.oa.controller.para.BillUo;
import com.it.oa.controller.para.FinanceBillQo;
import com.it.oa.entity.BillEntity;
import com.it.oa.entity.ContractEntity;
import com.it.oa.entity.CustomerEntity;
import com.it.oa.mapper.BillMapper;
import com.it.oa.service.BillService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "财务管理/发票管理")
@RestController
@RequestMapping("/api/financeBill")
@Slf4j
public class FinanceBillController {
    @Resource
    private BillService billService;
    @Resource
    private BillMapper billMapper;


    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<BillDto>> getPage(Page<BillEntity> page, FinanceBillQo para) {
        MPJLambdaWrapper<BillEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, BillEntity::getContractId);
        wrapper.leftJoin(CustomerEntity.class, CustomerEntity::getId, ContractEntity::getCustomerId);

        wrapper.between(toBool(para.getStartTime()), BillEntity::getCreateTime, para.getStartTime(), para.getEndTime())
                .eq(StringUtil.toBool(para.getCheckStatus()), BillEntity::getCheckStatus, para.getCheckStatus())
                .eq(StringUtil.toBool(para.getStatus()), BillEntity::getStatus, para.getStatus())
                .eq(StringUtil.toBool(para.getBillType()), BillEntity::getBillType, para.getBillType())
                .eq(StringUtil.toBool(para.getCheckStatus()), BillEntity::getCheckStatus, para.getCheckStatus())
                .and(StringUtil.toBool(para.getSearch()),
                        wrapper2 -> wrapper2.like(BillEntity::getBillName, para.getSearch())
                                .or().like(ContractEntity::getContractName, para.getSearch())
                                .or().like(CustomerEntity::getCustomerName, para.getSearch())
                );
        wrapper.selectAll(BillEntity.class);
        wrapper.select(ContractEntity::getContractName, ContractEntity::getContractMoney);
        return ApiResult.success(billMapper.selectJoinPage(page, BillDto.class, wrapper));
    }

    @ApiOperation(value = "审核")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody BillUo uo) {
        billService.lambdaUpdate().eq(BillEntity::getId, uo.getId())
                .set(BillEntity::getCheckStatus, uo.getCheckStatus())
                .set(BillEntity::getNote, uo.getNote()) // todo 备注字段覆盖?
                .update();
        return ApiResult.success();
    }

    @ApiOperation(value = "开票")
    @PostMapping("/openBill")
    public ApiResult<Boolean> openBill(@RequestBody BillEntity entity) {
        billService.updateById(entity);
        return ApiResult.success();
    }
}