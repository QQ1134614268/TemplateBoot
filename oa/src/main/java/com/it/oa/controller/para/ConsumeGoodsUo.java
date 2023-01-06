package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConsumeGoodsUo {
    @ApiModelProperty(value = "领用人或组织id", example = "1", required = false)
    private Integer lendId;
    @ApiModelProperty(value = "领用人或组织", example = "test_1", required = false)
    private String lendName;
    @ApiModelProperty(value = "备注", example = "test_1", required = false)
    private String note;
    @ApiModelProperty(value = "领用物品", example = "", required = false)
    private List<ConsumeGoodsUo2> goodsList;
}
