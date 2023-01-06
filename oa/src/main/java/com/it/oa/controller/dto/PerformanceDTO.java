package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PerformanceDTO {
    @ApiModelProperty(value = "考核得分", example = "0.1", required = false)
    private Float score;
    @ApiModelProperty(value = "绩效考核开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    private LocalDate date;
}
