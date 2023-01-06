package com.it.oa.controller.dto;


import com.it.oa.entity.ScoreLevelEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ScoreLevelDto {
    @ApiModelProperty(value = "评分方式", example = "test_1", required = false)
    private String type;
    @ApiModelProperty(value = "评分说明", example = "test_1", required = false)
    private String description;

    List<ScoreLevelEntity> levels = new ArrayList<>();
}