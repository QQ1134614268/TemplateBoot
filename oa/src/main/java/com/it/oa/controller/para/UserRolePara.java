package com.it.oa.controller.para;

import com.it.oa.controller.para.DepartmentVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRolePara {
    @ApiModelProperty(value = "角色id", example = "-127623817", required = false)
    private Integer roleId;
    @ApiModelProperty(value = "用户或组织", example = "[]", required = false)
    private List<DepartmentVo> list = new ArrayList<>();
}
