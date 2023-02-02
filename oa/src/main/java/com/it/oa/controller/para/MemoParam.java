package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "待办")
public class MemoParam implements Serializable {
    @ApiModelProperty(value = "待办内容", example = "早会")
    private String content;
    @ApiModelProperty(value = "备注内容")
    private String note;
    @ApiModelProperty(value = "提醒时间")
    private Date remindTime;
    @ApiModelProperty(value = "重复提醒")
    private Date repeatRemindTime;
}