package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ContactsParam implements Serializable {
    @ApiModelProperty(value = "组织id")
    private String orgId;
    @ApiModelProperty(value = "用户搜索")
    private String search;
}
