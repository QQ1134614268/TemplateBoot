package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.FinanceTypeDto;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.FinanceTypeEntity;
import com.it.oa.service.FinanceTypeService;
import com.it.oa.util.FrontUtil;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Api(tags = "财务管理/账目设置/账目分类")
@RestController
@RequestMapping("/api/financeType")
@Slf4j
public class FinanceTypeController {
    @Resource
    private FinanceTypeService financeTypeService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody FinanceTypeEntity financeTypeEntity) {
        //  todo type 需要 同级名称不同
        financeTypeEntity.setParentId(FrontUtil.getLast(financeTypeEntity.getParentIds()));
        return ApiResult.success(financeTypeService.save(financeTypeEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getTree")
    public ApiResult<List<FinanceTypeDto>> getTree(String category) {
        List<FinanceTypeEntity> all = financeTypeService.lambdaQuery().eq(StringUtil.toBool(category), FinanceTypeEntity::getCategory, category).list();
        List<FinanceTypeDto> list = all.stream().map(vo -> {
            FinanceTypeDto dto = new FinanceTypeDto();
            dto.setType(vo.getType());
            dto.setCategory(vo.getCategory());
            dto.setParentId(vo.getParentId());
            dto.setId(vo.getId());
            return dto;
        }).collect(Collectors.toList());

        List<FinanceTypeDto> tree = new ArrayList<>();
        for (FinanceTypeDto entity : list) {
            if (entity.getParentId() == null) {
                tree.add(entity);
            }
            for (FinanceTypeDto entity1 : list) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        getParentIds(tree);
        return ApiResult.success(tree);
    }

    public void getParentIds(List<FinanceTypeDto> tree) {
        if (tree == null || tree.isEmpty()) {
            return;
        }
        for (FinanceTypeDto dto : tree) {
            for (FinanceTypeDto dto1 : dto.getChildren()) {
                dto1.getParentIds().addAll(dto.getParentIds());
                dto1.getParentIds().add(dto.getId());
            }
            getParentIds(dto.getChildren());
        }
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody FinanceTypeEntity financeTypeEntity) {
        financeTypeEntity.setParentId(FrontUtil.getLast(financeTypeEntity.getParentIds()));
        return ApiResult.success(financeTypeService.updateById(financeTypeEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(financeTypeService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(financeTypeService.removeByIds(para.getIds()));
    }
}