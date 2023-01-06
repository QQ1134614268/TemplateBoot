package com.it.oa.controller.dto;

import com.it.oa.entity.CompanyEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyInfoDto extends CompanyEntity {
    @ApiModelProperty(value = "企业成员", example = "1")
    private Long memberNum;
    @ApiModelProperty(value = "企业部门", example = "1")
    private Long orgNum;
}
