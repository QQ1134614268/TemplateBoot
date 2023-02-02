package com.it.oa.controller.para;

import com.it.oa.entity.CustomerContactEntity;
import com.it.oa.entity.CustomerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerBo {
    @ApiModelProperty(value = "客户基本信息", example = "1", required = false)
    CustomerEntity customerEntity;

    @ApiModelProperty(value = "联系人信息", example = "1", required = false)
    CustomerContactEntity customerContactEntity;
}
