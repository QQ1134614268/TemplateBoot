package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrganizationPara {
    @ApiModelProperty(value = "搜索姓名|手机号码", example = "test", required = false)
    private String search;
}