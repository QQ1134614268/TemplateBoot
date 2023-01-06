package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.GroupCode;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.controller.para.EnumPara3;
import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Api(tags = "客户管理/客户设置")
@RestController
@RequestMapping("/api/enum")
@Slf4j
public class EnumController {
    @Resource
    private EnumService enumService;
    // @Resource
    // private Tagse enumService;

    @ApiOperation(value = "业务设置/客户来源")
    @PostMapping("/createCustomerFrom")
    public ApiResult<Boolean> createCustomerFrom(@RequestBody EnumPara3 enumPara3) {
        enumService.createOrUpdateEnum(GroupCode.CUSTOMER_FROM, enumPara3.getList());
        enumService.removeByIds(enumPara3.getDelList());
        return ApiResult.success();
    }

    @ApiOperation(value = "业务设置/获取客户来源")
    @GetMapping("/getCustomerFrom")
    public ApiResult<List<EnumEntity>> getCustomerFrom() {
        return ApiResult.success(enumService.getEnum(GroupCode.CUSTOMER_FROM));
    }

    @ApiOperation(value = "业务设置/续费类型")
    @PostMapping("/createRepayType")
    public ApiResult<Boolean> createRepayType(@RequestBody EnumPara3 enumPara3) {
        enumService.createOrUpdateEnum(GroupCode.REPAY_TYPE, enumPara3.getList());
        enumService.removeByIds(enumPara3.getDelList());
        return ApiResult.success();
    }

    @ApiOperation(value = "业务设置/续费类型")
    @GetMapping("/getRepayType")
    public ApiResult<List<EnumEntity>> getRepayType() {
        return ApiResult.success(enumService.getEnum(GroupCode.REPAY_TYPE));
    }

    @ApiOperation(value = "客户标签/标签组")
    @PostMapping("/createTagGroup")
    public ApiResult<Boolean> createTagGroup(@RequestBody EnumParaPara para) {
        return ApiResult.success(enumService.createOrUpdateEnum(GroupCode.TAR_GROUP, para));
    }

    @ApiOperation(value = "客户标签/标签组")
    @GetMapping("/getTagGroup")
    public ApiResult<List<EnumEntity>> getTagGroup() {
        return ApiResult.success(enumService.getEnum(GroupCode.TAR_GROUP));
    }

    @ApiOperation(value = "客户标签/标签")
    @PostMapping("/createCustomerTag")
    public ApiResult<Boolean> createCustomerTag(@RequestBody EnumParaPara para) {
        return ApiResult.success(enumService.createOrUpdateEnum(GroupCode.CUSTOMER_TAG, para));
    }

    @ApiOperation(value = "客户标签/标签")
    @GetMapping("/getCustomerTag")
    public ApiResult<List<EnumEntity>> getCustomerTag() {
        List<EnumEntity> tagGroup = enumService.getEnum(GroupCode.TAR_GROUP);
        List<EnumEntity> tag = enumService.getEnum(GroupCode.CUSTOMER_TAG);
        tagGroup.forEach(vo -> {
            List<EnumEntity> child = tag.stream().filter(tagVo -> Objects.equals(tagVo.getParentId(), vo.getId())).collect(Collectors.toList());
            vo.setChildren(child);
        });
        return ApiResult.success(tagGroup);
    }

    @ApiOperation(value = "创建客户分类")
    @PostMapping("/createCustomerType")
    public ApiResult<Boolean> createCustomerType(@RequestBody EnumParaPara para) {
        return ApiResult.success(enumService.createOrUpdateEnum(GroupCode.CUSTOMER_TYPE, para));
    }

    @ApiOperation(value = "获取客户分类")
    @GetMapping("/getCustomerType")
    public ApiResult<Page<EnumEntity>> getCustomerType(Page<EnumEntity> page) {
        return ApiResult.success(enumService.getEnum(page, GroupCode.CUSTOMER_TYPE));
    }

    @Hidden
    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody EnumEntity enumEntity) {
        return ApiResult.success(enumService.save(enumEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<EnumEntity>> getPage(Page<EnumEntity> page, EnumEntity enumEntity) {
        return ApiResult.success(enumService.page(page, new QueryWrapper<>(enumEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody EnumEntity enumEntity) {
        return ApiResult.success(enumService.updateById(enumEntity));
    }

    @ApiOperation(value = "根据id删除, 分类数据")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(enumService.removeByIds(para.getIds()));
    }
}