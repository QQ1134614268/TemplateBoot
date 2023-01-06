package com.it.oa.controller.para;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@ApiModel
@Data
public class PerformancePara2 {
    @ApiModelProperty(value = "绩效考核周期", example = "test_1", required = false)
    private String cycle;
    @ApiModelProperty(value = "开始时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    private LocalDate startDate;
    @ApiModelProperty(value = "结束时间", example = "Tue Jul 05 12:35:58 CST 2022", required = false)
    private LocalDate endDate;
    @ApiModelProperty(value = "组织id", example = "2", required = false)
    private Integer orgId;
    @ApiModelProperty(value = "考核状态", example = "test_1", required = false)
    private String status;
    @ApiModelProperty(value = "被考核人ids", example = "[]", required = false)
    private List<Integer> userIds;
    @ApiModelProperty(value = "考核人ids", example = "[]", required = false)
    private List<Integer> leaderIds;

}