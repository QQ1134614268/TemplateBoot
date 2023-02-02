package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CheckStatisticsDto {
    @ApiModelProperty(value = "等级名称", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '等级名称'")
    private String levelName;
    @ApiModelProperty(value = "个数", example = "1", required = false)
    private Integer count;
}
