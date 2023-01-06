package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CheckPara {
    @ApiModelProperty(value = "绩效考核周期", example = "test_1", required = false)
    private String cycle;
    @ApiModelProperty(value = "开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    private LocalDate startDate;
    @ApiModelProperty(value = "结束时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    private LocalDate endDate;
    @ApiModelProperty(value = "组织id", example = "2", required = false)
    private Integer orgId;
    @ApiModelProperty(value = "组织id", example = "2", required = false)
    private Integer userId;
}
