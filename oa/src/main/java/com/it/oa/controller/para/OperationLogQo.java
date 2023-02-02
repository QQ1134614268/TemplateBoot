package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OperationLogQo extends BasePara {

    @ApiModelProperty(value = "行为搜索", example = "1", required = false)
    String action;
}
