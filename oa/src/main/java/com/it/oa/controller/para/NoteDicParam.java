package com.it.oa.controller.para;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "文件夹")
public class NoteDicParam implements Serializable {
    @ApiModelProperty(value = "父级文件夹Id", example = "1", required = true)
    private Integer parentId;
    @ApiModelProperty(value = "文件夹名称", example = "我的", required = true)
    private String dicName;
}
