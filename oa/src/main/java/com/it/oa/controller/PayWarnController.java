package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.MemoType;
import com.it.oa.controller.para.DelPara;
import com.it.oa.entity.ContractEntity;
import com.it.oa.entity.EnumEntity;
import com.it.oa.entity.MemoEntity;
import com.it.oa.mapper.MemoMapper;
import com.it.oa.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.it.oa.config.constant.MemoType.PayType.PAY_WARN;

@Api(tags = "客户管理/合同管理/付款提醒")
@RestController
@RequestMapping("/api/payWarn")
@Slf4j
public class PayWarnController {
    public static final String type = MemoType.RENEWAL_REMINDER;
    public static final String payType = PAY_WARN;
    @Resource
    private MemoService memoService;
    @Resource
    private MemoMapper memoMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody MemoEntity memoEntity) {
        memoEntity.setCreate();
        memoEntity.setPayType(PAY_WARN);
        memoEntity.setPayType(payType);
        return ApiResult.success(memoService.create(memoEntity, type));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<MemoEntity>> getPage(Page<MemoEntity> page) {
        MPJLambdaWrapper<MemoEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, MemoEntity::getContractId);
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, MemoEntity::getRepayTypeId);
        wrapper.eq(MemoEntity::getType, type);
        wrapper.eq(MemoEntity::getPayType, payType);
        wrapper.select(ContractEntity::getContractName);
        wrapper.selectAs(EnumEntity::getValue, MemoEntity::getRepayType);
        wrapper.selectAll(MemoEntity.class);
        IPage<MemoEntity> ret = memoMapper.selectJoinPage(page, MemoEntity.class, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody MemoEntity memoEntity) {
        return ApiResult.success(memoService.updateById(memoEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(memoService.removeById(para.getId()));
    }
}