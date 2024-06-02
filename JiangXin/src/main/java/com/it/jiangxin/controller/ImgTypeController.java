package com.it.jiangxin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.controller.vo.IdsPara;
import com.it.jiangxin.entity.EnumEntity;
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
    public ApiResult<Boolean> create(@RequestBody EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        return ApiResult.success(enumService.save(enumEntity));
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<EnumEntity>> getPage(Page<EnumEntity> page, EnumEntity enumEntity) {
        Page<EnumEntity> page1 = getPage2(page, enumEntity);
        return ApiResult.success(page1);
    }

    public Page<EnumEntity> getPage2(Page<EnumEntity> page, EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        // enumService.lambdaQuery().list()
        return enumService.page(page, new QueryWrapper<>(enumEntity));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody EnumEntity enumEntity) {
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
