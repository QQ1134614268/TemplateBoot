package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.LogEntity;
import com.it.jiangxin.entity.vo.LogQo;
import com.it.jiangxin.service.LogService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Tag(name = "日志")
@RestController
@RequestMapping("/api/LogController")
@Slf4j
public class LogController {
    @Resource
    private LogService logService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody LogEntity entity) {
        return ApiResult.success(logService.save(entity));
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<LogEntity>> getPage(Page<LogEntity> page, LogQo qo) {
        page = logService.lambdaQuery()
                .like(BoolUtils.toBool(qo.getUserName()), LogEntity::getUserName, qo.getUserName())
                .ge(BoolUtils.toBool(qo.getStartTime()), LogEntity::getUserName, qo.getStartTime())
                .le(BoolUtils.toBool(qo.getEndTime()), LogEntity::getUserName, qo.getEndTime())
                .orderBy(true, false, LogEntity::getCreateTime)
                .page(page);
        return ApiResult.success(page);
    }

}