package com.it.oa.controller;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ReportCommentDto;
import com.it.oa.controller.para.DelPara;
import com.it.oa.entity.ReportCommentEntity;
import com.it.oa.entity.ReportEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.ReportCommentMapper;
import com.it.oa.mapper.ReportMapper;
import com.it.oa.service.ReportCommentService;
import com.it.oa.service.ReportService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "个人办公/办公中心/汇报/评论")
@RestController
@RequestMapping("/api/reportComment")
@Slf4j
public class ReportCommentController {
    @Resource
    private ReportCommentService reportCommentService;
    @Resource
    private ReportCommentMapper reportCommentMapper;
    @Resource
    private UserService userService;
    @Resource
    private ReportMapper reportMapper;

    @Resource
    private ReportService reportService;

    @ApiOperation("新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody ReportCommentEntity reportCommentEntity) {
        reportCommentEntity.setUserId(JwtUtil.getUserId());
        reportService.lambdaUpdate().set(ReportEntity::getLeaderAppraise, reportCommentEntity.getContent()).eq(ReportEntity::getId, reportCommentEntity.getReportId()).update();
        return ApiResult.success(reportCommentService.save(reportCommentEntity));
    }


    @ApiOperation("根据汇报id查询评论")
    @GetMapping("/getPage")
    public ApiResult<List<ReportCommentDto>> getPage(Integer reportId) {
        MPJLambdaWrapper<ReportCommentEntity> queryWrapper = new MPJLambdaWrapper<>();
        queryWrapper.eq(ReportCommentEntity::getReportId, reportId);
        queryWrapper.leftJoin(UserEntity.class, UserEntity::getId, ReportCommentEntity::getUserId);
        queryWrapper.selectAll(ReportCommentEntity.class);
        queryWrapper.select(UserEntity::getStaffName, UserEntity::getAvatar);
        return ApiResult.success(reportCommentMapper.selectJoinList(ReportCommentDto.class, queryWrapper));
    }

    @ApiOperation("根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        ReportCommentEntity entity = reportCommentService.getById(para.getId());
        reportCommentService.removeById(para.getId());
        ReportCommentEntity newEntity = reportCommentService.lambdaQuery().eq(ReportCommentEntity::getReportId, entity.getReportId())
                .orderByDesc(ReportCommentEntity::getCreateTime).last("limit 1").one();
        String leaderAppraise = newEntity == null ? null : entity.getContent();
        reportService.lambdaUpdate().set(ReportEntity::getLeaderAppraise, leaderAppraise).eq(ReportEntity::getId, entity.getReportId()).update();
        return ApiResult.success();
    }
}