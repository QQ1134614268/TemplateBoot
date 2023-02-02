package com.it.oa.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class MenuDTO {
    @ApiModelProperty(value = "菜单id", example = "1", required = false)
    private Integer id;
    @ApiModelProperty(value = "菜单名称", example = "test_1", required = false)
    private String menuName;
    @ApiModelProperty(value = "父级菜单id", example = "671964697", required = false)
    private Integer parentId;
    @ApiModelProperty(value = "顺序", example = "-1059915402", required = false)
    private Integer menuOrder;
    @ApiModelProperty(value = "子节点", required = false)
    private List<MenuDTO> children = new ArrayList<>();
}