package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "登陆")
public class BillParam implements Serializable {
    @ApiModelProperty(value = "发票范围", example = "test", required = false)
    private String person;
    @ApiModelProperty(value = "发票搜索", example = "test", required = false)
    private String search;
}
