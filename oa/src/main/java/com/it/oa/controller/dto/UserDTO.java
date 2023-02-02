package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserDTO {

    @ApiModelProperty(value = "组织id")
    private String orgId;
    @ApiModelProperty(value = "姓名")
    private String staffName;
    @ApiModelProperty(value = "职位")
    private String postName;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "员工id")
    private String id;
    @ApiModelProperty(value = "部门名称")
    private String orgName;
    @ApiModelProperty(value = "邮箱")
    private String email;
}
