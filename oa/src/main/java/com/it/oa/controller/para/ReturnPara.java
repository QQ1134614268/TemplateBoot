package com.it.oa.controller.para;

import com.it.oa.entity.FixGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReturnPara {

    @ApiModelProperty(value = "id", example = "[]", required = false)
    List<FixGoodsEntity> list;
    @ApiModelProperty(value = "id", example = "note", required = false)
    String note;
}
