package com.it.oa.controller.para;

import com.it.oa.entity.FixGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LendPersonDto extends FixGoodsEntity {
    @ApiModelProperty(value = "员工姓名", example = "test_1", required = true)
    private String staffName;
    @ApiModelProperty(value = "类型", example = "test_1", required = true)
    private String typeName;

}
