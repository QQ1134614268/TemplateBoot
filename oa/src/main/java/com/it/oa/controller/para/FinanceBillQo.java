package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FinanceBillQo extends BasePara {
    @ApiModelProperty(value = "发票审核id", example = "1", required = false)
    private String checkStatus;
    @ApiModelProperty(value = "开票状态id", example = "1", required = false)
    private String status;
    @ApiModelProperty(value = "发票类型id", example = "1", required = false)
    private String billType;
    @ApiModelProperty(value = "搜索(发票名称|客户名称|合同)", example = "1", required = false)
    private String search;
}
