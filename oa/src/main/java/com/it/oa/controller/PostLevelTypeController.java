package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "人事管理/职位管理/职级类别")
@RestController
@RequestMapping("/api/enum/postLevel")
@Slf4j
public class PostLevelTypeController {
    private static final String group = "POST_LEVEL";
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "创建")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody EnumParaPara para) {
        return ApiResult.success(enumService.createOrUpdateEnum(group, para));
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("/getAll")
    public ApiResult<List<EnumEntity>> getAll() {
        return ApiResult.success(enumService.getEnum(group));
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