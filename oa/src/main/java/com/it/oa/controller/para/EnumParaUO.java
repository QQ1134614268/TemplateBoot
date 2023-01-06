package com.it.oa.controller.para;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class EnumParaUO extends EnumParaPara {
    @ApiModelProperty(value = "id", example = "1", required = true)
    Integer id;
    @ApiModelProperty(value = "名称", example = "test_1", required = true)
    String value;
    @ApiModelProperty(value = "排序", example = "1", required = true)
    Integer sort;
    @ApiModelProperty(value = "父级id", example = "1", required = true)
    Integer parentId;
}