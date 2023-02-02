package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.PerformanceStatus;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.PerformanceBO;
import com.it.oa.controller.para.PerformanceQo;
import com.it.oa.entity.PerformanceEntity;
import com.it.oa.entity.PerformanceIndexEntity;
import com.it.oa.service.PerformanceIndexService;
import com.it.oa.service.PerformanceService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "个人办公/办公中心/绩效考核/我的考核")
@RestController
@RequestMapping("/api/performance")
@Slf4j
public class PerformanceController {

    @Resource
    private PerformanceService performanceService;
    @Resource
    private PerformanceIndexService performanceIndexService;
    @Resource
    private UserService userService;

    public ApiResult<PerformanceEntity> getDate(Page page) {
        LocalDate now = LocalDate.now();

        return ApiResult.success();
    }

    @ApiOperation(value = "当前考核")
    @GetMapping("/getCurrentExamine")
    public ApiResult<Page<PerformanceEntity>> getCurrentExamine(Page<PerformanceEntity> page) {
        return ApiResult.success(performanceService.lambdaQuery().eq(PerformanceEntity::getUserId, JwtUtil.getUserId())
                .eq(PerformanceEntity::getIsOpen, true)
                .eq(PerformanceEntity::getStatus, PerformanceStatus.UN_START)
                .page(page));
    }

    @ApiOperation(value = "我的自评")
    @GetMapping("/selfAppraise")
    public ApiResult<Page<PerformanceEntity>> selfAppraise(Page<PerformanceEntity> page, PerformanceEntity performanceEntity) {
        return ApiResult.success(performanceService.lambdaQuery().eq(PerformanceEntity::getUserId, JwtUtil.getUserId())
                .eq(StringUtil.toBool(performanceEntity.getCycle()), PerformanceEntity::getCycle, performanceEntity.getCycle())
                .page(page));
    }

    @ApiOperation(value = "查看考核")
    @GetMapping("/getExamine")
    public ApiResult<Page<PerformanceEntity>> getExamine(Page<PerformanceEntity> page, PerformanceQo qo) {

        // todo 获取部门人员
        List<Integer> ids = new ArrayList<>();

        Page ret = performanceService.lambdaQuery()
                // .in(PerformanceEntity::getUserId, ids)
                .eq(toBool(qo.getCycle()), PerformanceEntity::getCycle, qo.getCycle())
                .between(toBool(qo.getStartTime()), PerformanceEntity::getStartTime, qo.getStartTime(), qo.getEndTime())
                .eq(toBool(qo.getUserId()), PerformanceEntity::getUserId, qo.getUserId())
                .eq(toBool(qo.getStatus()), PerformanceEntity::getStatus, qo.getStatus())
                .page(page);
        return ApiResult.success(ret);
    }


    @ApiOperation(value = "查看")
    @GetMapping("/getExamineTree")
    public ApiResult<PerformanceEntity> getExamineTree(String id) {
        PerformanceEntity performanceEntity = performanceService.getById(id);
        List<PerformanceIndexEntity> all = performanceIndexService.lambdaQuery().eq(PerformanceIndexEntity::getPerformanceId, id).list();
        List<PerformanceIndexEntity> tree = new ArrayList<>();
        for (PerformanceIndexEntity entity : all) {
            if (entity.getParentId() == null) {
                tree.add(entity);
            }
            for (PerformanceIndexEntity entity2 : all) {
                if (entity.getId() == entity2.getParentId()) {
                    entity.getChildren().add(entity2);
                }
            }
        }
        performanceEntity.setList(tree);
        return ApiResult.success(performanceEntity);
    }

    @ApiOperation(value = "创建考核")
    @PostMapping("/createExamine")
    public ApiResult<PerformanceEntity> createExamine(@RequestBody PerformanceBO bo) {
        PerformanceEntity performanceEntity = new PerformanceEntity();
        performanceEntity.setCycle(bo.getCycle());
        performanceEntity.setUserId(bo.getUserId());
        performanceEntity.setAssessmentName(bo.getAssessmentName());
        performanceEntity.setStatus(PerformanceStatus.UN_START);
        performanceEntity.setIsOpen(false);
        performanceService.save(performanceEntity);

        for (PerformanceIndexEntity entity : bo.getList()) {
            performanceIndexService.save(entity);
            entity.getChildren().forEach(vo -> vo.setParentId(entity.getId()));
            performanceIndexService.saveBatch(entity.getChildren());
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "指标库")
    @PostMapping("/getIndexHub")
    public ApiResult<PerformanceEntity> getIndexHub(@RequestBody PerformanceBO bo) {
        // todo 指标库
        return ApiResult.success();
    }

    @ApiOperation(value = "启用")
    @PostMapping("/enableExamine")
    public ApiResult<PerformanceEntity> enableExamine(@RequestBody DelPara para) {
        performanceService.lambdaUpdate().eq(PerformanceEntity::getId, para.getId()).set(PerformanceEntity::getIsOpen, true).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "绩效审核")
    @PostMapping("/checkPerformance")
    public ApiResult<Page<PerformanceEntity>> checkPerformance(Page<PerformanceEntity> page, PerformanceQo qo) {

        // todo 获取部门人员
        List<Integer> ids = new ArrayList<>();

        Page<PerformanceEntity> ret = performanceService.lambdaQuery()
                // .in(PerformanceEntity::getUserId, ids)
                .eq(toBool(qo.getCycle()), PerformanceEntity::getCycle, qo.getCycle())
                .between(toBool(qo.getStartTime()), PerformanceEntity::getStartTime, qo.getStartTime(), qo.getEndTime())
                .eq(toBool(qo.getUserId()), PerformanceEntity::getUserId, qo.getUserId())
                .eq(toBool(qo.getStatus()), PerformanceEntity::getStatus, qo.getStatus())
                .page(page);
        return ApiResult.success(ret);
    }
}