package com.it.oa.controller.para;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class UserQo {

    @ApiModelProperty(value = "开始时间", example = "test_1", required = true)
    private String entryDateStart;
    @ApiModelProperty(value = "结束时间", example = "test_1", required = true)
    private String entryDateEnd;
    @ApiModelProperty(value = "性别", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '性别'")
    private String sex;
    @ApiModelProperty(value = "账号状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '账号状态'")
    private String accountStatus;
    @ApiModelProperty(value = "员工状态", example = "test_1", required = false)
    @Column(unique = false, nullable = true, columnDefinition = "varchar(255) COMMENT '性别'")
    private String staffStatus;

    @ApiModelProperty(value = "姓名,手机号,id", example = "test_1", required = false)
    private String search;

    @ApiModelProperty(value = "组织id", example = "1", required = false)
    private String orgId;
}