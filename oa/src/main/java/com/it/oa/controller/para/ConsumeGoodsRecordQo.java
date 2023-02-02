package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ConsumeGoodsRecordQo extends BasePara {
    @ApiModelProperty(value = "搜索物资名称", example = "", required = false)
    private String search;
    @ApiModelProperty(value = "搜索物资名称id", example = "1", required = false)
    private String typeId;
    @ApiModelProperty(value = "部门人员", example = "", required = false)
    private String lendName;
}
