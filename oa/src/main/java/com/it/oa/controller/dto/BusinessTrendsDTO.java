package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BusinessTrendsDTO {
    @ApiModelProperty(value = "日期")
    Date date;
    @ApiModelProperty(value = "收入")
    BigDecimal income;
    @ApiModelProperty(value = "支出")
    BigDecimal expenses;
}
