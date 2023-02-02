package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.PostExperienceEntity;
import com.it.oa.service.PostExperienceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/员工档案/任职经历")
@RestController
@RequestMapping("/api/postExperience")
@Slf4j
public class PostExperienceController {
    @Resource
    private PostExperienceService postExperienceService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody PostExperienceEntity postExperienceEntity) {
        return ApiResult.success(postExperienceService.save(postExperienceEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<PostExperienceEntity>> getPage(Page<PostExperienceEntity> page, PostExperienceEntity postExperienceEntity) {
        return ApiResult.success(postExperienceService.page(page, new QueryWrapper<>(postExperienceEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PostExperienceEntity postExperienceEntity) {
        return ApiResult.success(postExperienceService.updateById(postExperienceEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(postExperienceService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(postExperienceService.removeByIds(para.getIds()));
    }
}