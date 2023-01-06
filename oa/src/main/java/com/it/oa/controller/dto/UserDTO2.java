package com.it.oa.controller.dto;

import com.it.oa.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserDTO2 extends UserEntity {
    @ApiModelProperty(value = "部门", example = "-372385430", required = false)
    private String orgName;
    @ApiModelProperty(value = "职位", example = "-372385430", required = false)
    private String postName;
}
