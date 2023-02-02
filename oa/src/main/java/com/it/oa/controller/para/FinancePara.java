package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FinancePara extends BasePara {
    @ApiModelProperty(value = "账目类型", example = "test_1", required = false)
    private String category;
    @ApiModelProperty(value = "支付方式id", example = "1", required = false)
    private Integer payTypeId;
}