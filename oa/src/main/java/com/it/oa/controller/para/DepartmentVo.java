package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "组织")
public class DepartmentVo {

    @ApiModelProperty(value = "子节点")
    private List<DepartmentVo> children = new ArrayList<>();

    @ApiModelProperty(value = "id(部门或者用户id)", example = "1")
    private Integer id;

    @ApiModelProperty(value = "名称(部门或者用户名称)")
    private String name;

    @ApiModelProperty(value = "上级部门id", example = "1")
    private Integer parentId;

    @ApiModelProperty(value = "部门主管id", example = "1")
    private Integer leaderId;

    @ApiModelProperty(value = "部门介绍", example = "test_1", required = false)
    private String description;

    @ApiModelProperty(value = "是组织")
    private Boolean isOrg;

}
