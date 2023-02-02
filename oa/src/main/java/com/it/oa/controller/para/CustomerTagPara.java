package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomerTagPara {
    @ApiModelProperty(value = "对象的id", example = "1", required = true)
    List<Integer> customerIds;
    @ApiModelProperty(value = "标签id", example = "1", required = true)
    List<Integer> tagIds;
}
