package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UsePara {
    @ApiModelProperty(value = "对象的id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "启用", example = "true", required = true)
    private Boolean isUse;
}
