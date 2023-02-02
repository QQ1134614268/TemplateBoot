package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.MemoType;
import com.it.oa.controller.para.*;
import com.it.oa.entity.*;
import com.it.oa.mapper.BillMapper;
import com.it.oa.mapper.ContractMapper;
import com.it.oa.mapper.CustomerMapper;
import com.it.oa.mapper.MemoMapper;
import com.it.oa.service.*;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "客户管理/客户列表")
@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    public static class CustomerStatus {
        public static final String follow = "跟进中";
        public static final String finish = "跟进中";
    }

    @Resource
    private ContractService contractService;
    @Resource
    private BillService billService;
    @Resource
    private CustomerService customerService;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private MemoService memoService;
    @Resource
    private CustomerTagService customerTagService;
    @Resource
    private CustomerContactService customerContactService;
    @Resource
    private MemoMapper memoMapper;
    @Resource
    private BillMapper billMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody CustomerBo bo) {
        CustomerEntity customerEntity = bo.getCustomerEntity();
        customerEntity.setChargePersonId(JwtUtil.getUserId());
        customerEntity.setStatus(CustomerStatus.follow);
        customerService.save(customerEntity);
        CustomerContactEntity customerContactEntity = bo.getCustomerContactEntity();
        customerContactEntity.setCustomerId(customerEntity.getId());
        customerContactService.save(customerContactEntity);

        List<EnumEntity> tags = customerEntity.getTags();

        List<CustomerTagEntity> list = tags.stream().map(vo -> {
            CustomerTagEntity e = new CustomerTagEntity();
            e.setCustomerId(customerEntity.getId());
            e.setTagId(vo.getId());
            return e;
        }).collect(Collectors.toList());
        customerTagService.saveBatch(list);
        return ApiResult.success();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<CustomerEntity>> getPage(Page<CustomerEntity> page, CustomerPara para) {

        MPJLambdaWrapper<CustomerEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, CustomerEntity::getChargePersonId);
        wrapper.eq(toBool(para.getChargePersonId()), CustomerEntity::getChargePersonId, para.getChargePersonId());
        wrapper.eq(toBool(para.getTypeId()), CustomerEntity::getTypeId, para.getTypeId());
        wrapper.eq(toBool(para.getStatus()), CustomerEntity::getStatus, para.getStatus());
        wrapper.and(toBool(para.getSearch()), orWrapper -> orWrapper.like(CustomerEntity::getCustomerName, para.getSearch())
                .or().like(CustomerEntity::getPhone, para.getSearch()));
        wrapper.selectAll(CustomerEntity.class);
        wrapper.selectAs(UserEntity::getStaffName, CustomerEntity::getChargePerson);

        // wrapper.leftJoin(CustomerEntity.class, CustomerEntity::getId, CustomerEntity::getChargePersonId);

        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, CustomerEntity::getTypeId);
        wrapper.selectAs(EnumEntity::getValue, CustomerEntity::getTypeName);
        // wrapper.leftJoin(EnumEntity2.class, EnumEntity2::getId, CustomerEntity::getCustomerFromId);
        // wrapper.selectAs(EnumEntity2::getValue, CustomerEntity::getCustomerFrom);
        // todo 最后跟进时间,
        //   客户来源, | 客户分类
        //   客户标签,
        //   分页, 1-N(标签)
        //   标签独立使用一张表

        IPage<CustomerEntity> ret = customerMapper.selectJoinPage(page, CustomerEntity.class, wrapper);
        ret.getRecords().forEach(vo -> vo.setTags(customerTagService.getCustomerTag(vo.getId())));
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CustomerEntity customerEntity) {
        editTag(customerEntity.getId(), customerEntity.getTags());
        customerService.updateById(customerEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(customerService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(customerService.removeByIds(para.getIds()));
    }

    @ApiOperation(value = "客户,合同,发票 转移")
    @PostMapping("/change")
    public ApiResult<Boolean> change(@RequestBody ChangeVO vo) {
        customerService.lambdaUpdate()
                .in(CustomerEntity::getId, vo.getCustomerIds())
                .set(CustomerEntity::getChargePersonId, vo.getUserId()).update();

        if (vo.getIsContract()) {
            contractService.lambdaUpdate().in(ContractEntity::getCustomerId, vo.getCustomerIds()).set(ContractEntity::getChargePersonId, vo.getUserId()).update();
        }
        if (vo.getIsBill()) {
            List<ContractEntity> contractEntityList = contractService.lambdaQuery()
                    .in(ContractEntity::getCustomerId, vo.getCustomerIds())
                    .select(ContractEntity::getId)
                    .list();
            List<Integer> contractIds = contractEntityList.stream().map(ContractEntity::getId).collect(Collectors.toList());
            if (!contractIds.isEmpty()) {
                billService.lambdaUpdate().in(BillEntity::getContractId, contractIds).set(BillEntity::getSalesmanId, vo.getUserId()).update();
            }
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "设置标签(批量, 只有增加)")
    @PostMapping("/setTag")
    public ApiResult<Boolean> setTag(@RequestBody CustomerTagPara para) {
        CustomerTagEntity en;
        List<CustomerTagEntity> list = new ArrayList<>();
        for (Integer customerId : para.getCustomerIds()) {
            for (Integer tagId : para.getTagIds()) {
                en = new CustomerTagEntity();
                en.setTagId(tagId);
                en.setCustomerId(customerId);
                list.add(en);
            }
        }

        for (CustomerTagEntity entity : list) {
            List<CustomerTagEntity> db = customerTagService.list(new QueryWrapper<>(entity));
            if (db.isEmpty()) {
                customerTagService.save(entity);
            }
        }
        // customerTagService.saveOrUpdateBatch(list);    // toto 唯一索引
        return ApiResult.success();
    }

    @ApiOperation(value = "设置标签(单个, 可修改删除)")
    @PostMapping("/updateTag")
    public ApiResult<Boolean> updateTag(@RequestBody CustomerEntity customerEntity) {
        editTag(customerEntity.getId(), customerEntity.getTags());
        return ApiResult.success();
    }

    private void editTag(Integer customerId, List<EnumEntity> tags) {
        List<CustomerTagEntity> list = new ArrayList<>();
        for (EnumEntity enumEntity : tags) {
            CustomerTagEntity e = new CustomerTagEntity();
            e.setTagId(enumEntity.getId());
            e.setCustomerId(customerId);
            CustomerTagEntity customerTagEntity = customerTagService.getOne(new QueryWrapper<>(e), false);
            if (customerTagEntity == null) {
                customerTagService.save(e);
                list.add(e);
            } else {
                list.add(customerTagEntity);
            }
        }
        // tags
        // customerTagService.saveOrUpdateBatch(tags); // 唯一索引
        List<Integer> ids = list.stream().map(CustomerTagEntity::getId).collect(Collectors.toList());
        customerTagService.lambdaUpdate().notIn(CustomerTagEntity::getId, ids).remove();
        // customerTagService.removeByIds(list.stream().map(CustomerTagEntity::getId).collect(Collectors.toList()));
    }

    @ApiOperation(value = "设置状态")
    @PostMapping("/setStatus")
    public ApiResult<Boolean> setStatus(@RequestBody CustomerStatusPara para) {
        customerService.lambdaUpdate().eq(CustomerEntity::getId, para.getId()).set(CustomerEntity::getStatus, para.getStatus()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "关注")
    @PostMapping("/updateFollow")
    public ApiResult<Boolean> remind(@RequestBody FollowPara para) {
        customerService.lambdaUpdate().eq(CustomerEntity::getId, para.getId())
                .set(CustomerEntity::getIsFollow, para.getIsFollow()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "跟进提醒")
    @GetMapping("/remind")
    public ApiResult<Boolean> remind(@RequestBody MemoEntity memoEntity) {
        // undo 是否使用
        memoService.create(memoEntity, MemoType.CUSTOMER_FOLLOW_UP);
        return ApiResult.success();
    }

    @ApiOperation(value = "查看/付款记录")
    @GetMapping("/getPayRecord")
    public ApiResult<IPage<PayRecordEntity>> getPayRecord(Page<ContractEntity> page, Integer id) {

        MPJLambdaWrapper<ContractEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(PayRecordEntity.class, PayRecordEntity::getContractId, ContractEntity::getId);
        wrapper.eq(ContractEntity::getCustomerId, id);
        wrapper.select(ContractEntity::getContractName);
        wrapper.selectAll(PayRecordEntity.class);
        IPage<PayRecordEntity> ret = contractMapper.selectJoinPage(page, PayRecordEntity.class, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "查看/付款提醒/回款提醒/付款提醒")
    @GetMapping("/getPayWarn")
    public ApiResult<IPage<MemoEntity>> getPayWarn(Page<ContractEntity> page, Integer customerId) {
        return ApiResult.success(getWarn(page, customerId, MemoType.PayType.PAY_WARN));
    }

    @ApiOperation(value = "查看/付款提醒/回款提醒/续费提醒")
    @GetMapping("/getRePayWarn")
    public ApiResult<IPage<MemoEntity>> getRePayWarn(Page<ContractEntity> page, Integer customerId) {
        return ApiResult.success(getWarn(page, customerId, MemoType.PayType.REPAY_WARN));
    }

    public IPage<MemoEntity> getWarn(Page<ContractEntity> page, Integer customerId, String payType) {
        List<ContractEntity> vos = contractService.lambdaQuery().eq(ContractEntity::getCustomerId, customerId).select(ContractEntity::getId).list();
        List<Integer> ids = vos.stream().map(ContractEntity::getId).collect(Collectors.toList());

        MPJLambdaWrapper<MemoEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, MemoEntity::getContractId);
        wrapper.select(ContractEntity::getContractName);
        wrapper.selectAll(MemoEntity.class);
        wrapper.in(MemoEntity::getContractId, ids);
        wrapper.eq(MemoEntity::getType, MemoType.RENEWAL_REMINDER);
        wrapper.eq(MemoEntity::getPayType, payType);
        return memoMapper.selectJoinPage(page, MemoEntity.class, wrapper);
    }

    @ApiOperation(value = "查看/发票")
    @GetMapping("/getBill")
    public ApiResult<IPage<BillEntity>> getBill(Page<ContractEntity> page, Integer customerId) {
        List<ContractEntity> vos = contractService.lambdaQuery().eq(ContractEntity::getCustomerId, customerId).select(ContractEntity::getId).list();
        List<Integer> ids = vos.stream().map(ContractEntity::getId).collect(Collectors.toList());

        MPJLambdaWrapper<BillEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(ContractEntity.class, ContractEntity::getId, BillEntity::getContractId);
        wrapper.select(ContractEntity::getContractName);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, BillEntity::getSalesmanId);
        wrapper.selectAs(UserEntity::getStaffName, BillEntity::getSalesman);
        wrapper.selectAll(BillEntity.class);

        wrapper.in(BillEntity::getContractId, ids);

        return ApiResult.success(billMapper.selectJoinPage(page, BillEntity.class, wrapper));

    }
}