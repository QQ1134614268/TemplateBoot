package com.it.oa.controller.dto;

import com.it.oa.entity.FinanceTypeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FinanceTypeDto extends FinanceTypeEntity {
    @ApiModelProperty(value = "子节点", example = "", required = false)
    private List<FinanceTypeDto> children = new ArrayList<>();

}
