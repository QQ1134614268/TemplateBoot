package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyWorkbenchPara {
    @ApiModelProperty(value = "企业文化语", example = "test_1", required = true)
    private String companyCulture;
    @ApiModelProperty(value = "工作台背景", example = "test_1", required = true)
    private String workBackgroundImg;
}
