package com.it.oa.controller.dto;

import com.it.oa.entity.ConsumeGoodsRecordEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangeDetailDto extends ConsumeGoodsRecordEntity {

    @ApiModelProperty(value = "物资名称", example = "test_1", required = false)
    private String goodsName;
    @ApiModelProperty(value = "物资分类", example = "test_1", required = false)
    private String typeName;
    @ApiModelProperty(value = "物资型号", example = "test_1", required = false)
    private String model;

    // @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    // private String businessType;
    // @ApiModelProperty(value = "变动数量", example = "1", required = false)
    // private Integer changeNum;
    // @ApiModelProperty(value = "变动时间", example = "1", required = false, hidden = true)
    // private Date updateTime;
    // @ApiModelProperty(value = "变动者id", example = "1", required = false, hidden = true)
    // private Integer updateBy;

    @ApiModelProperty(value = "变动者name", example = "1", required = false)
    private String updatePersonName;
    @ApiModelProperty(value = "操作人", example = "1", required = false)
    private Integer createBy;
}
