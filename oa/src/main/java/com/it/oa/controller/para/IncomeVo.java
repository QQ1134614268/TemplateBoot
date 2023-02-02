package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomeVo {
    @ApiModelProperty(value = "账目金额", example = "0.1", required = false)
    private BigDecimal financeMoney;
    @ApiModelProperty(value = "账目分类", example = "", required = false)
    private String type;
}
