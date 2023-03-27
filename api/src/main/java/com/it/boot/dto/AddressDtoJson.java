package com.it.boot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @date 2023-03-27 16:25
 */
@ApiModel
@Data
public class AddressDtoJson {

    @ApiModelProperty(value = "名称", example = "1")
    private String name;

    @ApiModelProperty(value = "省市县名", example = "1")
    private List<String> names;
}
