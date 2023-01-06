package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserPermissionPara2 {
    @ApiModelProperty(value = "部门id", required = false)
    List<Integer> roleIdList;
    @ApiModelProperty(value = "部门id", example = "1", required = false)
    Integer userId;
}
