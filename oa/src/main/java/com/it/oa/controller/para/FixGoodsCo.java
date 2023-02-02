package com.it.oa.controller.para;

import com.it.oa.entity.FixGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FixGoodsCo extends FixGoodsEntity {
    @ApiModelProperty(value = "入库数量", example = "1", required = false)
    private Integer num;
}
