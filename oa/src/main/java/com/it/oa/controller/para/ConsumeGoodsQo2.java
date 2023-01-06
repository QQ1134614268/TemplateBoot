package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class ConsumeGoodsQo2 {

    @ApiModelProperty(value = "消耗物资id", example = "1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务类型'")
    private Integer consumeGoodsId;
    @ApiModelProperty(value = "业务类型", example = "test_1", required = false)
    private String businessType;
    @ApiModelProperty(value = "部门人员", example = "test_1", required = false)
    private String name;
    // @ApiModelProperty(value = "部门人员id", example = "test_1", required = false)
    // @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '业务类型'")
    // private String lendId;

}
