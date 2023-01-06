package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPermissionPara {
    @ApiModelProperty(value = "部门id", example = "-127623817", required = false)
    private String orgId;
    @ApiModelProperty(value = "搜索(姓名|电话)", example = "-127623817", required = false)
    private String search;
}
