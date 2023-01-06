package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NumPara {
    @ApiModelProperty(value = "入库数量", example = "1", required = false)
    Integer num;
}
