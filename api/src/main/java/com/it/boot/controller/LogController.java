package com.it.boot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.LogEntity;
import com.it.boot.entity.qo.LogQo;
import com.it.boot.service.LogService;
import com.it.boot.util.BoolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Tag(name = "日志")
@RestController
@RequestMapping("/api/LogController")
@Slf4j
public class LogController {
    @Resource
    private LogService logService;

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<LogEntity>> getPage(Page<LogEntity> page, LogQo qo) {
        page = logService.lambdaQuery()
                .like(BoolUtils.toBool(qo.getUserName()), LogEntity::getUserName, qo.getUserName())
                .ge(BoolUtils.toBool(qo.getStartTime()), LogEntity::getUserName, qo.getStartTime())
                .le(BoolUtils.toBool(qo.getEndTime()), LogEntity::getUserName, qo.getEndTime())
                .page(page);
        return ApiResult.success(page);
    }
}