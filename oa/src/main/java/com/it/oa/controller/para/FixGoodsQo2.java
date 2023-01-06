package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FixGoodsQo2 {

    @ApiModelProperty(value = "消耗物资id", example = "1", required = false)
    private Integer fixGoodsId;
    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    private String businessType;
    @ApiModelProperty(value = "部门人员", example = "test_1", required = false)
    private String name;
}
