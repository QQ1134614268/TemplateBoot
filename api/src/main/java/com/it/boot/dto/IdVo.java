package com.it.boot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @date 2022-10-22 18:41
 */
@ApiModel
@Data
public class IdVo {
    @ApiModelProperty(value = "对象id", example = "1")
    private Integer id;
}
