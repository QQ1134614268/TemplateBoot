package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FixGoodsRecordQo extends BasePara {
    @ApiModelProperty(value = "搜索物资名称|物资编号", example = "", required = false)
    private String search;
    @ApiModelProperty(value = "物资状态", example = "", required = false)
    private String status;
    @ApiModelProperty(value = "搜索物资名称", example = "1", required = false)
    private Integer typeId;
    @ApiModelProperty(value = "部门人员", example = "", required = false)
    private String lendName;
}
