package com.it.oa.controller.para;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OrganizationDTO {
    @ApiModelProperty(value = "用户id", example = "1", required = true)
    Integer userId;
    @ApiModelProperty(value = "名称", example = "test_1", required = true)
    String name;
    @ApiModelProperty(value = "组织id", example = "2", required = true)
    Integer orgId;
}