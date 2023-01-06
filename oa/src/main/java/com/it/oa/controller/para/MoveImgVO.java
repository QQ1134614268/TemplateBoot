package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MoveImgVO {
    @ApiModelProperty(value = "删除对象集合的id", example = "[1,2,3]", required = true)
    private List<Integer> ids;
    @ApiModelProperty(value = "父节点id", example = "1", required = true)
    private Integer parentId;
}
