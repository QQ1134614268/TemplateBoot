package com.it.oa.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserRoleDto {
    @ApiModelProperty(value = "id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "员工id", example = "1", required = false)
    private Integer userId;
    @ApiModelProperty(value = "姓名", example = "-127623817", required = false)
    private String staffName;
    @ApiModelProperty(value = "部门", example = "-127623817", required = false)
    private String orgName;
    @ApiModelProperty(value = "职位", example = "-413844420", required = false)
    private String postName;
    @ApiModelProperty(value = "启用状态", example = "1", required = false)
    private Boolean isUse;
}