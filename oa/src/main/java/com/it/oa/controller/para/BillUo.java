package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BillUo {
    @ApiModelProperty(value = "发票id", example = "1", required = false)
    Integer id;
    @ApiModelProperty(value = "审核状态", example = "1", required = false)
    String checkStatus;
    @ApiModelProperty(value = "备注", example = "备注1", required = false)
    String note;
}
