package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.*;
import com.it.oa.entity.BillEntity;
import com.it.oa.entity.ContractEntity;
import com.it.oa.entity.CustomerEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.service.BillService;
import com.it.oa.service.ContractService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "客户管理/合同管理")
@RestController
@RequestMapping("/api/contract")
@Slf4j
public class ContractController {
    public static final int INT = 1; // 合同范围 : 我负责的客户
    public static final int INT1 = 2; // 合同范围 : 我查看的客户
    @Resource
    private ContractService contractService;
    @Resource
    private BillService billService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody ContractEntity contractEntity) {
        contractEntity.setChargePersonId(JwtUtil.getUserId());
        return ApiResult.success(contractService.save(contractEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<ContractEntity>> getPage(Page<ContractEntity> page, ContractPara para) {

        MPJLambdaWrapper<ContractEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(CustomerEntity.class, CustomerEntity::getId, ContractEntity::getCustomerId);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, ContractEntity::getChargePersonId);
        wrapper.eq(toBool(para.getCustomerId()), ContractEntity::getCustomerId, para.getCustomerId());
        wrapper.eq(Objects.equals(para.getChargePersonId(), INT), ContractEntity::getChargePersonId, JwtUtil.getUserId());
        wrapper.ne(Objects.equals(para.getChargePersonId(), INT1), ContractEntity::getChargePersonId, JwtUtil.getUserId());
        if (toBool(para.getSearch())) wrapper.like(ContractEntity::getContractName, para.getSearch());
        // todo 合同结款,合同续费

        wrapper.select(CustomerEntity::getCustomerName);
        wrapper.selectAll(ContractEntity.class);
        wrapper.selectAs(UserEntity::getStaffName, ContractEntity::getChargePerson);

        return ApiResult.success(contractService.page(page, wrapper));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody ContractEntity contractEntity) {
        return ApiResult.success(contractService.updateById(contractEntity));
    }

    @ApiOperation(value = "合同,发票 转移")
    @PostMapping("/change")
    public ApiResult<Boolean> change(@RequestBody ChangeVO vo) {
        contractService.lambdaUpdate().in(ContractEntity::getId, vo.getContractIds()).set(ContractEntity::getChargePersonId, vo.getUserId()).update();
        if (vo.getIsBill()) {
            billService.lambdaUpdate().in(BillEntity::getContractId, vo.getContractIds()).set(BillEntity::getSalesmanId, vo.getUserId()).update();
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "关注")
    @PostMapping("/updateFollow")
    public ApiResult<Boolean> remind(@RequestBody FollowPara para) {
        contractService.lambdaUpdate().eq(ContractEntity::getId, para.getId())
                .set(ContractEntity::getIsFollow, para.getIsFollow()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(contractService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(contractService.removeByIds(para.getIds()));
    }
}