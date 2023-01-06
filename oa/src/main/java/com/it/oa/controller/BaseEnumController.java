package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// @RestController
@RequestMapping("/api/baseEnum")
public class BaseEnumController {
    @Resource
    private EnumService enumService;

    private String getGroup() {
        return "default";
    }


    @ApiOperation(value = "创建")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody List<EnumParaPara> list) {
        return ApiResult.success(enumService.createOrUpdateEnum(getGroup(), list));
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("/getAll")
    public ApiResult<List<EnumEntity>> getAll() {
        return ApiResult.success(enumService.getEnum(getGroup()));
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