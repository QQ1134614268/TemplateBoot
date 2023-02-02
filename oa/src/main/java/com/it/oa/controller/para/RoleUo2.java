package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoleUo2 {
    @ApiModelProperty(value = "id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "身份名称", example = "-127623817", required = false)
    private String roleName;
    @ApiModelProperty(value = "启用状态", example = "-413844420", required = false)
    private Boolean isUse;
    @ApiModelProperty(value = "菜单", example = "[1,2]", required = false)
    private List<Integer> menus;
}
