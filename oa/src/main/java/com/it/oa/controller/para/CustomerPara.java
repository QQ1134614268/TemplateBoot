package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CustomerPara implements Serializable {
    @ApiModelProperty(value = "客户范围id", example = "1", required = true)
    private Integer chargePersonId;
    @ApiModelProperty(value = "客户分类", example = "1", required = true)
    private Integer typeId;
    @ApiModelProperty(value = "成交状态", example = "", required = true)
    private String status;
    @ApiModelProperty(value = "客户标签", example = "优质客户,重要客户", required = true)
    private List<Integer> tagIds;

    @ApiModelProperty(value = "客户搜索", example = "小小", required = true)
    private String search;

}
