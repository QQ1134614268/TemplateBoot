package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.PostLevelEntity;
import com.it.oa.service.PostLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/职位管理/职级管理")
@RestController
@RequestMapping("/api/postLevel")
@Slf4j
public class PostLevelController {
    @Resource
    private PostLevelService postLevelService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody PostLevelEntity postLevelEntity) {
        postLevelEntity.setCreate();
        return ApiResult.success(postLevelService.save(postLevelEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<PostLevelEntity>> getPage(Page<PostLevelEntity> page, PostLevelEntity postLevelEntity) {
        return ApiResult.success(postLevelService.page(page, new QueryWrapper<>(postLevelEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PostLevelEntity postLevelEntity) {
        return ApiResult.success(postLevelService.updateById(postLevelEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(postLevelService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(postLevelService.removeByIds(para.getIds()));
    }
}