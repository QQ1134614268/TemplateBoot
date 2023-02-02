package com.it.oa.controller.para;

import com.it.oa.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "个人办公/办公中心/汇报")
@Data
public class ReportReplyPara extends BaseEntity {
    @ApiModelProperty(value = "员工id", example = "1053892493", required = true)
    private Integer userId;
    @ApiModelProperty(value = "汇报类型", example = "test_1", required = true)
    private String type;
    @ApiModelProperty(value = "今日工作内容", example = "test_1", required = true)
    private String content;
    @ApiModelProperty(value = "明日计划", example = "test_1", required = false)
    private String plan;
    @ApiModelProperty(value = "备注", example = "test_1", required = true)
    private String note;
    @ApiModelProperty(value = "上级评价", example = "test_1", required = false)
    private String leaderAppraise;
}