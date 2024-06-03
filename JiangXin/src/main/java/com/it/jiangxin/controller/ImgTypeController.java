package com.it.jiangxin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.service.EnumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "图片类型")
@RestController
@RequestMapping("/api/ImgTypeController")
@Slf4j
public class ImgTypeController extends BaseEnumController {
    public static final String IMG_TYPE = "IMG-TYPE";
    @Resource
    private EnumService enumService;

    public String getGroupCode() {
        return IMG_TYPE;
    }

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Integer> create(@RequestBody SysEnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        boolean save = enumService.save(enumEntity);
        return ApiResult.success(enumEntity.getId());
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<SysEnumEntity>> getPage(Page<SysEnumEntity> page, SysEnumEntity enumEntity) {
        Page<SysEnumEntity> page1 = getPage2(page, enumEntity);
        return ApiResult.success(page1);
    }

    public Page<SysEnumEntity> getPage2(Page<SysEnumEntity> page, SysEnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        // enumService.lambdaQuery().list()
        return enumService.page(page, new QueryWrapper<>(enumEntity));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody SysEnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        return ApiResult.success(enumService.updateById(enumEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(enumService.removeByIds(para.getIds()));
    }

}
