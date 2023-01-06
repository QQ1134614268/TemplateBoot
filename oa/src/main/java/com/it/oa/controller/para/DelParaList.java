package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DelParaList {
    @ApiModelProperty(value = "删除对象集合的id", example = "[1,2,3]", required = true)
    private List<Integer> ids;
}