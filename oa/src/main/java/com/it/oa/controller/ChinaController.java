package com.it.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.entity.ChinaEntity;
import com.it.oa.service.ChinaService;
import com.it.oa.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "中国地区")
@RestController
@RequestMapping("/api/china")
@Slf4j
public class ChinaController {
    @Resource
    private ChinaService chinaService;

    @ApiOperation(value = "获取地区信息")
    @GetMapping("/getChinaTree")
    public ApiResult<List<ChinaEntity>> getChinaTree(Page page, ChinaEntity chinaEntity) {

        List<ChinaEntity> all = chinaService.list();
        return ApiResult.success(TreeUtil.getTree(all));
    }

}