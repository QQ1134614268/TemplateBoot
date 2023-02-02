package com.it.oa.controller.para;


import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FinanceRecordAnalysisQo extends BasePara {

    @ApiModelProperty(value = "等级", example = "1", required = false)
    private Integer level;
    @ApiModelProperty(value = "账目类别", example = "1", required = false)
    private String category;
}