package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.WorkExperienceEntity;
import com.it.oa.service.WorkExperienceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/员工档案/工作经历")
@RestController
@RequestMapping("/api/workExperience")
@Slf4j
public class WorkExperienceController {
    @Resource
    private WorkExperienceService workExperienceService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody WorkExperienceEntity workExperienceEntity) {
        return ApiResult.success(workExperienceService.save(workExperienceEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<WorkExperienceEntity>> getPage(Page<WorkExperienceEntity> page, WorkExperienceEntity workExperienceEntity) {
        return ApiResult.success(workExperienceService.page(page, new QueryWrapper<>(workExperienceEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody WorkExperienceEntity workExperienceEntity) {
        return ApiResult.success(workExperienceService.updateById(workExperienceEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(workExperienceService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(workExperienceService.removeByIds(para.getIds()));
    }
}