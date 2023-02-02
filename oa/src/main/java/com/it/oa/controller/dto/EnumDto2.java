package com.it.oa.controller.dto;

import com.it.oa.entity.EnumEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnumDto2 extends EnumEntity {
    @ApiModelProperty(value = "父级ids", example = "1", required = false)
    private List<Integer> parentIds = new ArrayList<>();
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<EnumEntity> children = new ArrayList<>();
}
