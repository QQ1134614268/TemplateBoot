package com.it.oa.controller.para;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class EnumParaPara2 {
    @ApiModelProperty(value = "名称", example = "test_1", required = true)
    String value;
    @ApiModelProperty(value = "排序", example = "1", required = true)
    Integer sort;
    @ApiModelProperty(value = "父级ids", example = "1", required = true)
    List<Integer> parentIds;
}