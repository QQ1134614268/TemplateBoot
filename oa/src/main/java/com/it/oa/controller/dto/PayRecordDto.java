package com.it.oa.controller.dto;

import com.it.oa.entity.PayRecordEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("财务审核")
public class PayRecordDto extends PayRecordEntity {
    @ApiModelProperty(value = "合同名称", example = "test_1", required = false)
    private String contractName;
    @ApiModelProperty(value = "负责人", example = "test_1", required = false)
    private String chargePerson;

    @ApiModelProperty(value = "申请时间", example = "2022-02-02 10:10:10", required = false)
    private Date createTime;
}
