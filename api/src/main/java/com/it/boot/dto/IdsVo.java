package com.it.boot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @date 2022-10-22 18:41
 */
@ApiModel
@Data
public class IdsVo {
    @ApiModelProperty(value = "对象id集合", example = "[1,2]")
    private List<Integer> ids;
}
