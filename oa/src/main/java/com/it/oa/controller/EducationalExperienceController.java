package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.EducationalExperienceEntity;
import com.it.oa.service.EducationalExperienceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/员工档案/教育经历")
@RestController
@RequestMapping("/api/educationalExperience")
@Slf4j
public class EducationalExperienceController {
    @Resource
    private EducationalExperienceService educationalExperienceService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody EducationalExperienceEntity educationalExperienceEntity) {
        return ApiResult.success(educationalExperienceService.save(educationalExperienceEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<EducationalExperienceEntity>> getPage(Page<EducationalExperienceEntity> page, EducationalExperienceEntity educationalExperienceEntity) {
        return ApiResult.success(educationalExperienceService.page(page, new QueryWrapper<>(educationalExperienceEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody EducationalExperienceEntity educationalExperienceEntity) {
        return ApiResult.success(educationalExperienceService.updateById(educationalExperienceEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(educationalExperienceService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(educationalExperienceService.removeByIds(para.getIds()));
    }
}