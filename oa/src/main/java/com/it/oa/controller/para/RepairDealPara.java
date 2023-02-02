package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepairDealPara {

    @ApiModelProperty(value = "固定物资id", example = "1", required = true)
    private Integer id;
    @ApiModelProperty(value = "备注", example = "1", required = false)
    private String note;
    @ApiModelProperty(value = "类型(取值: 入库, 报废 )", example = "1", required = true)
    private String type;
    @ApiModelProperty(value = "金额", example = "1", required = true)
    private Float repairMoney;

}
