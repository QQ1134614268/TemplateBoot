package com.it.boot.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Schema(title = "国家编码", example = "ZH")
    private String countryCode;

    @Schema(title = "城市id", example = "1")
    private int cityId;

}
