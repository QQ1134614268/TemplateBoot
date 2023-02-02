package com.it.oa.controller.para;

import com.it.oa.controller.para.EnumParaPara;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class EnumPara3 {

    @ApiModelProperty(value = "修改的对象", example = "[]", required = true)
    List<EnumParaPara> list;
    @ApiModelProperty(value = "删除的id", example = "[]", required = true)
    List<Integer> delList;
}
