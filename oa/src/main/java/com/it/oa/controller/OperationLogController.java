package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.OperationLogQo;
import com.it.oa.entity.OperationLogEntity;
import com.it.oa.service.OperationLogService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "系统管理/系统设置/操作日志")
@RestController
@RequestMapping("/api/operationLog")
@Slf4j
public class OperationLogController {
    @Resource
    private OperationLogService operationLogService;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<OperationLogEntity>> getPage(Page<OperationLogEntity> page, OperationLogQo para) {
        return ApiResult.success(operationLogService.lambdaQuery()
                .between(toBool(para.getStartTime()), OperationLogEntity::getOperationTime, para.getStartTime(), para.getEndTime())
                .like(StringUtil.toBool(para.getAction()), OperationLogEntity::getAction, para.getAction())
                .page(page)
        );
    }
}