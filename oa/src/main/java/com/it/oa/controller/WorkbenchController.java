package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.MemoDTO;
import com.it.oa.controller.para.PerformanceDTO;
import com.it.oa.controller.para.PerformancePara;
import com.it.oa.entity.AnnouncementEntity;
import com.it.oa.entity.MemoEntity;
import com.it.oa.service.AnnouncementService;
import com.it.oa.service.MemoService;
import com.it.oa.service.PerformanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "个人办公/工作台")
@RestController
@RequestMapping("/api/workbench")
@Slf4j
public class WorkbenchController {

    @Resource
    private MemoService memoService;
    @Resource
    private PerformanceService performanceService;
    @Resource
    private AnnouncementService announcementService;


    @ApiOperation(value = "我的待办")
    @GetMapping("/myUndo")
    public ApiResult<List<MemoEntity>> myUndo() {
        return memoService.getTodayMemo(false);

    }

    @ApiOperation(value = "我的已办")
    @GetMapping("/myDo")
    public ApiResult<List<MemoEntity>> myDo() {
        return memoService.getTodayMemo(true);

    }

    @ApiOperation(value = "日历")
    @GetMapping("/calendar")
    public ApiResult<List<MemoDTO>> calendar(Integer year, Integer month) {
        return memoService.calendar(year, month);
    }

    @ApiOperation(value = "绩效考核")
    @GetMapping("/myPerformance")
    public ApiResult<List<PerformanceDTO>> myPerformance(PerformancePara para) {
        return performanceService.myPerformance(para);
    }

    @ApiOperation(value = "公告")
    @GetMapping("/myAnnouncement")
    public ApiResult<List<AnnouncementEntity>> myAnnouncement() {
        return announcementService.myAnnouncement();
    }

    @ApiOperation(value = "新建待办")
    @PostMapping("/createUndo")
    public ApiResult<Boolean> createUndo(@RequestBody MemoEntity memoEntity) {
        return memoService.createUndo(memoEntity);
    }
}