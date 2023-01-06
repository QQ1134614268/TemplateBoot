package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.PayRecordDto;
import com.it.oa.controller.para.FinanceCheckQo;
import com.it.oa.controller.para.PayRecordUo;
import com.it.oa.entity.*;
import com.it.oa.mapper.PayRecordMapper;
import com.it.oa.service.BillService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "财务管理/财务审核")
@RestController
@RequestMapping("/api/financeCheck")
@Slf4j
public class FinanceCheckController {
    @Resource
    private BillService billService;
    @Resource
    private PayRecordMapper payRecordMapper;


    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<PayRecordDto>> getPage(Page<PayRecordEntity> page, FinanceCheckQo para) {

        MPJLambdaWrapper<PayRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, PayRecordEntity::getContractId);
        wrapper.leftJoin(CustomerEntity.class, CustomerEntity::getId, ContractEntity::getCustomerId);

        wrapper.between(toBool(para.getStartTime()), BillEntity::getCreateTime, para.getStartTime(), para.getEndTime())
                .eq(StringUtil.toBool(para.getCheckStatus()), BillEntity::getCheckStatus, para.getCheckStatus())
                .eq(StringUtil.toBool(para.getCheckStatus()), BillEntity::getCheckStatus, para.getCheckStatus())
                .like(StringUtil.toBool(para.getSearch()), ContractEntity::getContractName, para.getSearch());
        wrapper.selectAll(PayRecordEntity.class);
        wrapper.selectAs(ContractEntity::getContractName, PayRecordDto::getContractName);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, CustomerEntity::getChargePersonId);
        wrapper.selectAs(UserEntity::getStaffName, PayRecordDto::getChargePerson);
        return ApiResult.success(payRecordMapper.selectJoinPage(page, PayRecordDto.class, wrapper));
    }

    @ApiOperation(value = "审核")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PayRecordUo uo) {
        billService.lambdaUpdate().eq(BillEntity::getId, uo.getId()).set(BillEntity::getCheckStatus, uo.getCheckStatus()).update();
        return ApiResult.success();
    }
}