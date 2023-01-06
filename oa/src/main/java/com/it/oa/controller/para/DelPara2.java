package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DelPara2 {
    @ApiModelProperty(value = "对象的id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "删除原因", example = "1", required = false)
    private String deleteReason;
}
