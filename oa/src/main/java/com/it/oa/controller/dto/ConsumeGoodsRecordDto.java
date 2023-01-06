package com.it.oa.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ConsumeGoodsRecordDto {

    @ApiModelProperty(value = "领用人或组织", example = "test_1", required = false)
    private String lendName;
    @ApiModelProperty(value = "领用数量", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '领用数量'")
    private String lendNum;
    @ApiModelProperty(value = "领用时间", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "datetime COMMENT '领用时间'")
    private LocalDateTime lendTime;
    @ApiModelProperty(value = "物资编号", example = "test_1", required = false)
    private String goodsNumber;

    @ApiModelProperty(value = "物资状态", example = "test_1", required = false)
    private String status;

    @ApiModelProperty(value = "物资名称", example = "test_1", required = false)
    private String goodsName;
    @ApiModelProperty(value = "物资型号", example = "test_1", required = false)
    private String model;
    @ApiModelProperty(value = "计量单位", example = "test_1", required = false)
    private String unit;


    @ApiModelProperty(value = "分类名", example = "test_1", required = false)
    private String typeName;

    @ApiModelProperty(value = "操作时间", example = "test_1", required = false)
    private Date createTime;
}
