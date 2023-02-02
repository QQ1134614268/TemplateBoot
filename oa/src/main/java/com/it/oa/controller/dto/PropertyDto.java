package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PropertyDto {
    @ApiModelProperty(value = "物资采购金额", example = "1", required = false)
    private Float purchaseAmount = 0f;
    @ApiModelProperty(value = "物资报废金额", example = "2", required = false)
    private Float scrapAmount = 0f;
    @ApiModelProperty(value = "物资维修金额", example = "3", required = false)
    private Float repairAmount = 0f;
}
