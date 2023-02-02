package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ConsumeGoodsUo2 {
    @ApiModelProperty(value = "消耗物资id", example = "1", required = false)
    private Integer consumeGoodsId;
    @ApiModelProperty(value = "领用数量", example = "1", required = false)
    private Integer lendNum;
}
