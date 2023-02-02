package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "我的待办,查询参数")
public class MemoPara {
    @ApiModelProperty(value = "业务类型", example = "test_1")
    private List<String> types;
    @ApiModelProperty(value = "待办内容", example = "早会")
    private String content;
    @ApiModelProperty(value = "备注内容")
    private String remarks;
    @ApiModelProperty(value = "提醒开始时间", required = true)
    private Date startTime;
    @ApiModelProperty(value = "提醒结束时间", required = true)
    private Date endTime;
    @ApiModelProperty(value = "重复提醒")
    private Date repeatRemindTime;
    @ApiModelProperty(value = "是否完成", example = "false")
    private Boolean isCompleted;
}