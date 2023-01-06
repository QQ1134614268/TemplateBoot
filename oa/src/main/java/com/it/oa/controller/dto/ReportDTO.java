package com.it.oa.controller.dto;

import com.it.oa.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "我的汇报")
@Data
public class ReportDTO extends BaseEntity {

    @ApiModelProperty(value = "员工id", example = "1")
    private Integer userId;
    @ApiModelProperty(value = "员工姓名")
    private String staffName;
    @ApiModelProperty(value = "汇报类型")
    private String type;
    @ApiModelProperty(value = "今日工作内容")
    private String content;
    @ApiModelProperty(value = "明日计划")
    private String plan;
    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "组织名")
    private String orgName;

    @ApiModelProperty(value = "上级评价", example = "test_1", required = false)
    private String leaderAppraise;
}
