package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DelPara {
    @ApiModelProperty(value = "对象的id", example = "1", required = true)
    private Integer id;
}