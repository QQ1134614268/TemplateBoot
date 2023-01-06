package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReturnQo {
    @ApiModelProperty(value = "id", example = "1", required = false)
    String id;
}
