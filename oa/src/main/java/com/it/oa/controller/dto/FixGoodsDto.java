package com.it.oa.controller.dto;

import com.it.oa.entity.FixGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FixGoodsDto extends FixGoodsEntity {
    @ApiModelProperty(value = "分类名称", example = "1", required = false)
    String typeName;
}
