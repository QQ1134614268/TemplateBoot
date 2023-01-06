package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnnoTypePara implements Serializable {
    @ApiModelProperty(value = "分类名称", example = "1", required = true)
    private String value;
    @ApiModelProperty(value = "排序", example = "1", required = true)
    private Integer sort;
    @ApiModelProperty(value = "状态", example = "1", required = true)
    private String status;

}
