package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FinanceCheckQo extends BasePara {
    @ApiModelProperty(value = "审核状态", example = "test_1", required = false)
    private String checkStatus;

    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    private String type;

    @ApiModelProperty(value = "搜索(合同名称)", example = "test_1", required = false)
    private String search;

}
