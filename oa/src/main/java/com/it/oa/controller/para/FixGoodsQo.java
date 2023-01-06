package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FixGoodsQo extends BasePara {
    @ApiModelProperty(value = "物资搜索", example = "1", required = false)
    private String search;
    @ApiModelProperty(value = "物资状态", example = "1", required = false)
    private String status;
}
