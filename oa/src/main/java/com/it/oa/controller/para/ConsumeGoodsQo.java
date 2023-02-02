package com.it.oa.controller.para;

import com.it.oa.controller.para.BasePara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ConsumeGoodsQo extends BasePara {
    @ApiModelProperty(value = "搜索(物资名称)", example = "test_1", required = false)
    private String search;
    @ApiModelProperty(value = "父级id", example = "1", required = false)
    private Integer typeId;
}
