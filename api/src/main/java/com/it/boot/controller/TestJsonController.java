package com.it.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.dto.IdVo;
import com.it.boot.entity.TestJsonEntity;
import com.it.boot.service.TestJsonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "测试/用户Jpa")
@Slf4j
@RestController
@RequestMapping("/api/TestJsonController")
public class TestJsonController {

    @Resource
    private TestJsonService testJsonService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody TestJsonEntity entity) {
        return ApiResult.success(testJsonService.save(entity));
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<TestJsonEntity>> getPage(Page<TestJsonEntity> page, TestJsonEntity testJsonEntity) {
        return ApiResult.success(testJsonService.page(page, new QueryWrapper<>(testJsonEntity)));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody TestJsonEntity testJsonEntity) {
        return ApiResult.success(testJsonService.updateById(testJsonEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdVo idVo) {
        return ApiResult.success(testJsonService.removeById(idVo.getId()));
    }
}
