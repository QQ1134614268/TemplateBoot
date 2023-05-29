package com.it.jiangxin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.vo.IdPara;
import com.it.jiangxin.controller.vo.IdsPara;
import com.it.jiangxin.entity.EnumEntity;
import com.it.jiangxin.service.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "图片类型")
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

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult create(@RequestBody EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        return ApiResult.success(enumService.save(enumEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page> getPage(Page page, EnumEntity enumEntity) {
        Page page1 = getPage2(page, enumEntity);
        return ApiResult.success(page1);
    }

    public Page getPage2(Page page, EnumEntity enumEntity) {
        enumEntity.setGroupCode(getGroupCode());
        // enumService.lambdaQuery().list()
        Page page1 = enumService.page(page, new QueryWrapper<>(enumEntity));
        return page1;
    }

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
