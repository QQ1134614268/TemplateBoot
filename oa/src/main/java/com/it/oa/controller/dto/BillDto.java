package com.it.oa.controller.dto;

import com.it.oa.entity.BillEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillDto extends BillEntity {
    @ApiModelProperty(value = "合同名称", example = "test_1", required = false)
    private String contractName;
    @ApiModelProperty(value = "合同金额", example = "0.1", required = false)
    private BigDecimal contractMoney;
    @ApiModelProperty(value = "客户名称", example = "test_1", required = false)
    private String customerName;
    @ApiModelProperty(value = "联系电话", example = "test_1", required = false)
    private String phone;
}
