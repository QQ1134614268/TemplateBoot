package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "个人办公/办公中心/汇报")
public class ReportVO {
    @ApiModelProperty(value = "汇报类型", example = "test_1", required = true)
    private String type;
    @ApiModelProperty(value = "今日工作内容", example = "test_1", required = true)
    private String content;
    @ApiModelProperty(value = "明日计划", example = "test_1", required = false)
    private String plan;
    @ApiModelProperty(value = "备注", example = "test_1", required = true)
    private String note;
}