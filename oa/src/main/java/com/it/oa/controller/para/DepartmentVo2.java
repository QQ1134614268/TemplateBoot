package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentVo2 {

    @ApiModelProperty(value = "子节点")
    private List<DepartmentVo2> children = new ArrayList<>();

    @ApiModelProperty(value = "部门id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    private String orgName;

    @ApiModelProperty(value = "上级部门", example = "1")
    private Integer parentId;

    @ApiModelProperty(value = "部门主管id", example = "1")
    private Integer leaderId;

    @ApiModelProperty(value = "部门介绍", example = "test_1", required = false)
    private String description;

    @ApiModelProperty(value = "是组织")
    private Boolean isOrg;

}
