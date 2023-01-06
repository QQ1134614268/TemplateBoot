package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.CheckStatisticsDto;
import com.it.oa.controller.para.CheckPara;
import com.it.oa.controller.para.DelPara2;
import com.it.oa.controller.para.PerformancePara2;
import com.it.oa.entity.PerformanceEntity;
import com.it.oa.entity.ScoreLevelEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.PerformanceMapper;
import com.it.oa.mapper.ScoreLevelMapper;
import com.it.oa.service.PerformanceService;
import com.it.oa.service.UserService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "人事管理/绩效考核/员工绩效")
@RestController
@RequestMapping("/api/staffPerformance")
@Slf4j
public class StaffPerformanceController {
    @Resource
    private PerformanceService performanceService;
    @Resource
    private PerformanceMapper performanceMapper;
    @Resource
    private ScoreLevelMapper scoreLevelMapper;
    @Resource
    private UserService userService;

    @ApiOperation("考核员工")
    @GetMapping("/getPage")
    public ApiResult<IPage<PerformanceEntity>> getPage(Page<PerformanceEntity> page, PerformancePara2 para2) {
        MPJLambdaWrapper<PerformanceEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, PerformanceEntity::getUserId);
        wrapper.eq(toBool(para2.getCycle()), PerformanceEntity::getCycle, para2.getCycle());
        wrapper.eq(toBool(para2.getStatus()), PerformanceEntity::getStatus, para2.getStatus());
        wrapper.in(toBool(para2.getUserIds()), PerformanceEntity::getUserId, para2.getUserIds());
        wrapper.in(toBool(para2.getLeaderIds()), PerformanceEntity::getLeaderId, para2.getLeaderIds());
        wrapper.between(toBool(para2.getStartDate()), PerformanceEntity::getStartTime, para2.getStartDate(), para2.getEndDate());
        wrapper.eq(toBool(para2.getOrgId()), UserEntity::getOrgId, para2.getOrgId());

        wrapper.select(UserEntity::getStaffName);

        wrapper.selectAll(PerformanceEntity.class);
        wrapper.leftJoin(ScoreLevelEntity.class, ScoreLevelEntity::getId, PerformanceEntity::getLevelId);
        wrapper.select(ScoreLevelEntity::getLevelName);
        IPage<PerformanceEntity> ret = performanceMapper.selectJoinPage(page, PerformanceEntity.class, wrapper);
        ret.getRecords().forEach(vo -> {
            userService.lambdaQuery().select(UserEntity::getStaffName).eq(UserEntity::getId, vo.getLevelId()).oneOpt()
                    .ifPresent(leaderVo -> vo.setLeaderName(leaderVo.getStaffName()));
        });
        return ApiResult.success(ret);
    }


    @ApiOperation("考核统计")
    @GetMapping("/checkStatistics")
    public ApiResult<List<CheckStatisticsDto>> checkStatistics(CheckPara para) {
        MPJLambdaWrapper<ScoreLevelEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(PerformanceEntity.class, PerformanceEntity::getLevelId, ScoreLevelEntity::getId);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, PerformanceEntity::getUserId);
        wrapper.eq(StringUtil.toBool(para.getCycle()), PerformanceEntity::getCycle, para.getCycle());
        wrapper.between(StringUtil.toBool(para.getStartDate()), PerformanceEntity::getCreateTime, para.getStartDate(), para.getEndDate());
        wrapper.eq(StringUtil.toBool(para.getOrgId()), UserEntity::getOrgId, para.getOrgId());
        wrapper.eq(StringUtil.toBool(para.getUserId()), UserEntity::getId, para.getUserId());

        wrapper.groupBy(ScoreLevelEntity::getId, ScoreLevelEntity::getLevelName);
        wrapper.select(ScoreLevelEntity::getLevelName);
        wrapper.selectCount(ScoreLevelEntity::getLevelName, CheckStatisticsDto::getCount);
        return ApiResult.success(scoreLevelMapper.selectJoinList(CheckStatisticsDto.class, wrapper));
    }

    @ApiOperation("删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara2 para) {
        performanceService.lambdaUpdate().eq(PerformanceEntity::getId, para.getId())
                .set(PerformanceEntity::getIsDelete, true)
                .set(PerformanceEntity::getDeleteReason, para.getDeleteReason())
                .update();
        return ApiResult.success();
    }

    @ApiOperation("评分记录")
    @PostMapping("/getScoreRecord")
    public ApiResult<Boolean> getScoreRecord(@RequestBody DelPara2 para) {
        return ApiResult.success();
    }

    @ApiOperation("删除记录")
    @PostMapping("/getDeletePerformance")
    public ApiResult<Boolean> getDeletePerformance(@RequestBody DelPara2 para) {
        performanceService.lambdaUpdate().eq(PerformanceEntity::getId, para.getId())
                .set(PerformanceEntity::getIsDelete, true)
                .set(PerformanceEntity::getDeleteReason, para.getDeleteReason())
                .update();
        return ApiResult.success();
    }
}