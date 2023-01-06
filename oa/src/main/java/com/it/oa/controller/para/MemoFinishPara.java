package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "我的待办,查询参数")
public class MemoFinishPara {

    @ApiModelProperty(value = "待办id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "是否完成", example = "false")
    private Boolean isCompleted;
}