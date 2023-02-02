package com.it.oa.controller.dto;

import com.it.oa.entity.ConsumeGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ConsumeGoodsDto extends ConsumeGoodsEntity {
    @ApiModelProperty(value = "分类名", example = "test_1", required = false)
    String typeName;
}
