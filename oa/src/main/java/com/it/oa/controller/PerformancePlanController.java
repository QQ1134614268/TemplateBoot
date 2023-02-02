package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.entity.PerformancePlanEntity;
import com.it.oa.entity.PerformancePlanUserEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.PerformancePlanUserMapper;
import com.it.oa.service.PerformancePlanService;
import com.it.oa.service.PerformancePlanUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "人事管理/绩效考核/绩效设置/考核计划")
@RestController
@RequestMapping("/api/performancePlan")
@Slf4j
public class PerformancePlanController {
    @Resource
    private PerformancePlanService performancePlanService;
    @Resource
    private PerformancePlanUserService performancePlanUserService;
    @Resource
    private PerformancePlanUserMapper performancePlanUserMapper;

    @ApiOperation(value = "获取")
    @GetMapping("/getPerformancePlan")
    public ApiResult<List<PerformancePlanEntity>> getPerformancePlan(PerformancePlanEntity performancePlanEntity) {
        List<PerformancePlanEntity> ret = performancePlanService.list(new QueryWrapper<>(performancePlanEntity));
        for (PerformancePlanEntity entity : ret) {
            MPJLambdaWrapper<PerformancePlanUserEntity> wrapper = new MPJLambdaWrapper<>();
            wrapper.leftJoin(UserEntity.class, UserEntity::getId, PerformancePlanUserEntity::getUserId);
            wrapper.selectAll(PerformancePlanUserEntity.class);
            wrapper.select(UserEntity::getStaffName);
            entity.setPlanUsers(performancePlanUserMapper.selectJoinList(PerformancePlanUserEntity.class, wrapper));
        }
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody PerformancePlanEntity performancePlanEntity) {
        // todo 可以选择组织
        performancePlanService.updateById(performancePlanEntity);

        List<PerformancePlanUserEntity> users = performancePlanEntity.getPlanUsers();
        users.forEach(vo -> vo.setPerformancePlanId(performancePlanEntity.getId()));
        performancePlanUserService.saveOrUpdateBatch(users);
        List<Integer> ids = users.stream().map(PerformancePlanUserEntity::getId).collect(Collectors.toList());
        if (ids.isEmpty()) {
            performancePlanUserService.lambdaUpdate().eq(PerformancePlanUserEntity::getPerformancePlanId, performancePlanEntity.getId())
                    .remove();
        } else {
            performancePlanUserService.lambdaUpdate().eq(PerformancePlanUserEntity::getPerformancePlanId, performancePlanEntity.getId())
                    .notIn(PerformancePlanUserEntity::getId, users.stream().map(PerformancePlanUserEntity::getId).collect(Collectors.toList())).remove();
        }
        return ApiResult.success();

    }

}