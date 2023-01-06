package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.Score;
import com.it.oa.controller.dto.ScoreLevelDto;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import com.it.oa.service.ScoreLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "人事管理/绩效考核/考核设置/考核评分")
@RestController
@RequestMapping("/api/scoreLevel")
@Slf4j
public class ScoreLevelController {
    @Resource
    private ScoreLevelService scoreLevelService;
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getAll")
    public ApiResult<ScoreLevelDto> getAll() {
        EnumEntity entity = enumService.lambdaQuery().eq(EnumEntity::getUniqueCode, Score.score_key).one();
        EnumEntity entity2 = enumService.lambdaQuery().eq(EnumEntity::getUniqueCode, Score.desc_key).one();

        ScoreLevelDto dto = new ScoreLevelDto();
        dto.setType(entity.getValue());
        dto.setDescription(entity2.getValue());
        dto.setLevels(scoreLevelService.list());
        return ApiResult.success(dto);
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public ApiResult<Boolean> save(@RequestBody ScoreLevelDto dto) {
        enumService.lambdaUpdate().eq(EnumEntity::getUniqueCode, Score.score_key)
                .set(EnumEntity::getValue, dto.getType()).update();

        enumService.lambdaUpdate().eq(EnumEntity::getUniqueCode, Score.desc_key)
                .set(EnumEntity::getValue, dto.getDescription()).update();
        // scoreLevelService.saveBatch(dto.getLevels());
        // scoreLevelService.lambdaUpdate().notIn(ScoreLevelEntity::getId, dto.getLevels().stream().map(ScoreLevelEntity::getId).collect(Collectors.toList())).remove();
        scoreLevelService.remove(new QueryWrapper<>());
        scoreLevelService.saveBatch(dto.getLevels());
        return ApiResult.success();
    }

}