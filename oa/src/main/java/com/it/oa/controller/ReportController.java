package com.it.oa.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.ReportDTO;
import com.it.oa.controller.para.MyReportPara;
import com.it.oa.controller.para.ReportPara;
import com.it.oa.controller.para.ReportVO;
import com.it.oa.entity.OrganizationEntity;
import com.it.oa.entity.ReportEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.ReportMapper;
import com.it.oa.service.ReportService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "个人办公/办公中心/汇报")
@RestController
@RequestMapping("/api/report")
@Slf4j
public class ReportController {
    @Resource
    private ReportService reportService;
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private UserService userService;

    @ApiOperation("填写汇报")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody ReportVO vo) {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setUserId(JwtUtil.getUserId());
        reportEntity.setType(vo.getType());
        reportEntity.setContent(vo.getContent());
        reportEntity.setPlan(vo.getPlan());
        reportEntity.setNote(vo.getNote());
        return ApiResult.success(reportService.save(reportEntity));
    }

    @ApiOperation(value = "查看汇报")
    @GetMapping("/getPage")
    public ApiResult<IPage<ReportDTO>> getPage(Page page, ReportPara para) {
        MPJLambdaWrapper<ReportEntity> queryWrapper = new MPJLambdaWrapper<>();
        queryWrapper.leftJoin(UserEntity.class, UserEntity::getId, ReportEntity::getUserId);
        queryWrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        queryWrapper.selectAll(ReportEntity.class);
        queryWrapper.select(OrganizationEntity::getOrgName);

        if (toBool(para.getStartTime())) queryWrapper.ge(ReportEntity::getCreateTime, para.getStartTime());
        if (toBool(para.getEndTime())) queryWrapper.le(ReportEntity::getCreateTime, para.getEndTime());

        if (toBool(para.getType())) queryWrapper.eq(ReportEntity::getType, para.getType());

        queryWrapper.eq(para.getUserId() != null, ReportEntity::getUserId, para.getUserId());
        return ApiResult.success(reportMapper.selectJoinPage(page, ReportDTO.class, queryWrapper));
    }

    @ApiOperation(value = "我的汇报")
    @GetMapping("/getMyReportPage")
    public ApiResult<IPage<ReportDTO>> getMyReportPage(Page page, MyReportPara para) {
        MPJLambdaWrapper<ReportEntity> queryWrapper = new MPJLambdaWrapper<>();
        queryWrapper.leftJoin(UserEntity.class, UserEntity::getId, ReportEntity::getUserId);
        queryWrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        queryWrapper.selectAll(ReportEntity.class);
        queryWrapper.select(OrganizationEntity::getOrgName);
        queryWrapper.select(UserEntity::getStaffName);

        if (toBool(para.getStartTime())) queryWrapper.ge(ReportEntity::getCreateTime, para.getStartTime());
        if (toBool(para.getEndTime())) queryWrapper.le(ReportEntity::getCreateTime, para.getEndTime());

        if (toBool(para.getType())) queryWrapper.eq(ReportEntity::getType, para.getType());

        return ApiResult.success(reportMapper.selectJoinPage(page, ReportDTO.class, queryWrapper));
    }

    @ApiOperation("根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody ReportEntity reportEntity) {
        return ApiResult.success(reportService.updateById(reportEntity));
    }

    @ApiOperation("获取人员")
    @PostMapping("/getUserList")
    public ApiResult<List<UserEntity>> getUserList() {
        return ApiResult.success(userService.lambdaQuery().select(UserEntity::getUserName, UserEntity::getStaffName, UserEntity::getId).list());
    }
}