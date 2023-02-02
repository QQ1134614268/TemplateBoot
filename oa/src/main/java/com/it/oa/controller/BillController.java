package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.BillParam;
import com.it.oa.controller.para.ChangeVO;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.BillEntity;
import com.it.oa.entity.ContractEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.BillMapper;
import com.it.oa.service.BillService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "客户管理/发票管理")
@RestController
@RequestMapping("/api/bill")
@Slf4j
public class BillController {
    @Resource
    private BillService billService;
    @Resource
    private BillMapper billMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody BillEntity billEntity) {
        billEntity.setCreate();
        return ApiResult.success(billService.save(billEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<BillEntity>> getPage(Page<BillEntity> page, BillParam para) {
        MPJLambdaWrapper<BillEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, BillEntity::getContractId);
        wrapper.select(ContractEntity::getContractName, ContractEntity::getContractMoney);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, BillEntity::getSalesmanId);
        wrapper.selectAs(UserEntity::getStaffName, BillEntity::getSalesman);
        wrapper.selectAll(BillEntity.class);

        wrapper.and(toBool(para.getSearch()), (wrapper2) ->
                wrapper2.like(BillEntity::getContactName, para.getSearch())
                        .or().like(BillEntity::getBillName, para.getSearch())
                        .or().like(BillEntity::getPhone, para.getSearch()));
        wrapper.eq(toBool(para.getPerson()), BillEntity::getSalesman, para.getPerson());
        return ApiResult.success(billMapper.selectJoinPage(page, BillEntity.class, wrapper));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody BillEntity billEntity) {
        billEntity.setSalesmanId(JwtUtil.getUserId());
        return ApiResult.success(billService.updateById(billEntity));
    }

    @ApiOperation(value = "发票 转移")
    @PostMapping("/change")
    public ApiResult<Boolean> change(@RequestBody ChangeVO vo) {
        billService.lambdaUpdate().in(BillEntity::getId, vo.getBillIds()).set(BillEntity::getSalesmanId, vo.getUserId()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(billService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(billService.removeByIds(para.getIds()));
    }
}