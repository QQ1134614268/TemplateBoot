package com.it.oa.controller.dto;

import com.it.oa.entity.ConsumeGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WarningDto extends ConsumeGoodsEntity {

    @ApiModelProperty(value = "物资名称", example = "test_1", required = false)
    private String goodsName;
    @ApiModelProperty(value = "物资型号", example = "test_1", required = false)
    private String model;
    @ApiModelProperty(value = "库存数量", example = "1", required = false)
    private Integer reserveNum;
    @ApiModelProperty(value = "分类名", example = "笔记本", required = false)
    private String typeName;
}
