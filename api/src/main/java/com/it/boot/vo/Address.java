package com.it.boot.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @ApiModelProperty(value = "国家编码", example = "ZH")
    private String countryCode;

    @ApiModelProperty(value = "城市id", example = "1")
    private int cityId;

}
