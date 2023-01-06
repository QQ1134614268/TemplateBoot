package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FixUsePara {
    @ApiModelProperty(value = "领用人的Id", example = "1", required = true)
    private Integer lendId;
    @ApiModelProperty(value = "领用人的名称", example = "", required = true)
    private String lendName;
    @ApiModelProperty(value = "固定物资的id", example = "[1,2,3]", required = true)
    private List<Integer> ids;
    @ApiModelProperty(value = "备注", example = "备注1", required = true)
    private String note;
}
