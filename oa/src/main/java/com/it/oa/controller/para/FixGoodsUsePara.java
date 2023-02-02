package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FixGoodsUsePara {
    @ApiModelProperty(value = "人员部门id", example = "1", required = false)
    private String lendId;
    @ApiModelProperty(value = "人员部门", example = "xxx", required = false)
    private String lendName;
    @ApiModelProperty(value = "备注", example = "[1,2,3]", required = false)
    private String note;
    @ApiModelProperty(value = "删除对象集合的id", example = "[1,2,3]", required = false)
    private List<Integer> ids;
}