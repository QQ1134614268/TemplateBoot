package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayRecordUo {
    @ApiModelProperty(value = "id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "审核状态", example = "checkStatus", required = false)
    private String checkStatus;
    @ApiModelProperty(value = "备注", example = "note", required = false)
    private String note;
}
