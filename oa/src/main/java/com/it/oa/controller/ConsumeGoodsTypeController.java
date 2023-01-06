package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.EnumParaPara2;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import com.it.oa.util.FrontUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.it.oa.config.constant.GroupCode.CONSUME_GOODS_TYPE;


@Api(tags = "行政管理/办公物资/物资管理/消耗物资/分类")
@RestController
@RequestMapping("/api/enum/consumeGoodsType")
@Slf4j
public class ConsumeGoodsTypeController {
    private static final String group = CONSUME_GOODS_TYPE;
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "创建")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody EnumParaPara2 para) {
        return ApiResult.success(enumService.createOrUpdateEnum(group, FrontUtil.toEnumParaPara(para)));
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("/getAll")
    public ApiResult<List<EnumEntity>> getAll() {
        List<EnumEntity> list = enumService.getEnum(group);
        List<EnumEntity> tree = new ArrayList<>();
        for (EnumEntity node : list) {
            if (node.getParentId() == null) {
                tree.add(node);
            }
            for (EnumEntity node2 : list) {
                if (Objects.equals(node.getId(), node2.getParentId())) {
                    node2.setParentIds(new ArrayList<>());
                    node2.getParentIds().addAll(node.getParentIds());
                    node2.getParentIds().add(node2.getParentId());
                    node.getChildren().add(node2);
                }
            }
        }
        return ApiResult.success(tree);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody EnumEntity enumEntity) {
        return ApiResult.success(enumService.updateById(enumEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }
}