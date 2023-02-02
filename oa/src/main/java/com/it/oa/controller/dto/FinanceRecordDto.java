package com.it.oa.controller.dto;

import com.it.oa.entity.FinanceRecordEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FinanceRecordDto extends FinanceRecordEntity {

    @ApiModelProperty(value = "账目类型", example = "test_1", required = false)
    private String category;
    @ApiModelProperty(value = "账目分类", example = "test_1", required = false)
    private String type;
    @ApiModelProperty(value = "支付方式", example = "微信支付", required = false)
    private String payType;
}
