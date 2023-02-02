package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangeDto {
    @ApiModelProperty(value = "采购数量", example = "1", required = false)
    Integer purchaseNum;
    @ApiModelProperty(value = "固定物资领取次数", example = "1", required = false)
    Integer lendCount;

    @ApiModelProperty(value = "消耗数量", example = "1", required = false)
    Integer consumeNum;

    @ApiModelProperty(value = "报废数量", example = "1", required = false)
    Integer scrapNum;

}
