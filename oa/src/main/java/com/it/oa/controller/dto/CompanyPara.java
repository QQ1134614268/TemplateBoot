package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyPara {
    @ApiModelProperty(value = "id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "logo")
    private String logo;
    @ApiModelProperty(value = "企业简称")
    private String shortName;
    @ApiModelProperty(value = "省份")
    private String province;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "县")
    private String area;
    @ApiModelProperty(value = "详细地址")
    private String address;
    @ApiModelProperty(value = "电话")
    private String phone;

}
