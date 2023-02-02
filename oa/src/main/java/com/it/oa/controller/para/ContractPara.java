package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "我的待办,查询参数")
public class ContractPara {
    @ApiModelProperty(value = "客户Id", example = "1", required = false)
    private Integer customerId;

    @ApiModelProperty(value = "合同范围", example = "1", required = false)
    private Integer chargePersonId;

    @ApiModelProperty(value = "合同结款", example = "早会")
    private String pay;
    @ApiModelProperty(value = "合同续费", example = "早会")
    private String repay;

    @ApiModelProperty(value = "合同名称", example = "", required = false)
    private String search;

}