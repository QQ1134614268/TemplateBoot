package com.it.jiangxin.controller;


import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.controller.vo.IdsPara;
import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.service.EnumService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Hidden
@RestController
@RequestMapping("/api/enum")
@Slf4j
public class BaseEnumController {
    @Resource
    private EnumService enumService;

    public String getGroupCode() {
        return "default";
    }

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        return ApiResult.success(enumService.save(enumEntity));
    }

    // @ApiOperation(value = "分页查询")
    // @GetMapping("/getPage")
    // public ApiResult<IPage> getPage(IPage page, EnumEntity enumEntity) {
    //     enumEntity.setGroupCode(getGroupCode());
    //     return ApiResult.success(enumService.page(page, new QueryWrapper<>(enumEntity)));
    // }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult updateById(@RequestBody EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        return ApiResult.success(enumService.updateById(enumEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult deleteById(@RequestBody IdPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(enumService.removeByIds(para.getIds()));
    }
}