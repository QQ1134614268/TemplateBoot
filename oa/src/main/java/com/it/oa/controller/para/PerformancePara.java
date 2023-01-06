package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "绩效查询")
public class PerformancePara implements Serializable {
    @ApiModelProperty(value = "周期", example = "月考核", required = true)
    private String cycle;
    @ApiModelProperty(value = "开始时间", example = "2022-07-01 00:00:00", required = true)
    private String startTime;
    @ApiModelProperty(value = "结束时间", example = "2022-08-01 00:00:00", required = true)
    private String endTime;
}

