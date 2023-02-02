package com.it.oa.controller.dto;

import com.it.oa.entity.FinanceTypeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class IncomeDto extends FinanceTypeEntity {
    @ApiModelProperty(value = "账目金额", example = "0.1", required = false)
    private BigDecimal financeMoney;
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<IncomeDto> children = new ArrayList<>();

}
