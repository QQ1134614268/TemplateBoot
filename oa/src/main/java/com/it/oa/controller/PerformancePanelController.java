package com.it.oa.controller;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.PerformanceDTO;
import com.it.oa.controller.para.PerformancePara;
import com.it.oa.entity.OrganizationEntity;
import com.it.oa.entity.PerformanceEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.PerformanceMapper;
import com.it.oa.service.PerformanceService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "个人办公/办公中心/绩效考核/考核统计")
@RestController
@RequestMapping("/api/performancePanel")
@Slf4j
public class PerformancePanelController {
    @Resource
    private UserService userService;
    @Resource
    private PerformanceMapper performanceMapper;
    @Resource
    private PerformanceService performanceService;


    @ApiOperation(value = "考核统计/我的部门")
    @GetMapping("/analysisDepartment")
    public ApiResult<List<PerformanceEntity>> analysisDepartment(PerformancePara para) {
        UserEntity currUser = userService.getById(JwtUtil.getUserId());
        Integer orgId = currUser.getOrgId();
        MPJLambdaWrapper<PerformanceEntity> wrapper = new MPJLambdaWrapper<>();

        wrapper.leftJoin(UserEntity.class, UserEntity::getId, PerformanceEntity::getUserId);
        wrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        wrapper.eq(PerformanceEntity::getCycle, para.getCycle());
        wrapper.ge(PerformanceEntity::getStartTime, para.getStartTime());
        wrapper.le(PerformanceEntity::getEndTime, para.getEndTime());
        wrapper.eq(UserEntity::getOrgId, orgId);

        wrapper.select(PerformanceEntity::getScore);
        wrapper.select(UserEntity::getStaffName);
        return ApiResult.success(performanceMapper.selectList(wrapper));
    }

    @ApiOperation(value = "考核统计/我的考核")
    @GetMapping("/myPerformance")
    public ApiResult<List<PerformanceDTO>> myPerformance(PerformancePara para) {
        return performanceService.myPerformance(para);

    }
}