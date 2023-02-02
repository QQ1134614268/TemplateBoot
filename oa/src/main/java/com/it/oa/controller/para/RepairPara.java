package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepairPara {
    @ApiModelProperty(value = "固定物资id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "备注", example = "1", required = false)
    private String note;
}
