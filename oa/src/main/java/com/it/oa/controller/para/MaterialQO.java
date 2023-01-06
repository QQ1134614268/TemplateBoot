package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialQO {
    @ApiModelProperty(value = "搜索", example = "test_1", required = false)
    private String search;
    @ApiModelProperty(value = "父级id", example = "1", required = false)
    private Integer parentId;
}
