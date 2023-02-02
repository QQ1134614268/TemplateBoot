package com.it.oa.controller.para;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("转移")
public class ChangeVO {
    @ApiModelProperty(value = "客户转移", example = "true", required = false)
    Boolean isCustomer;
    @ApiModelProperty(value = "合同转移", example = "true", required = false)
    Boolean isContract;
    @ApiModelProperty(value = "发票转移", example = "true", required = false)
    Boolean isBill;

    @ApiModelProperty(value = "被转移员工id", example = "true", required = true)
    Integer userId;

    @ApiModelProperty(value = "客户Ids", example = "[]", required = false)
    List<Integer> customerIds;
    @ApiModelProperty(value = "合同Ids", example = "[]", required = false)
    List<Integer> contractIds;
    @ApiModelProperty(value = "发票Ids", example = "[]", required = false)
    List<Integer> billIds;
}