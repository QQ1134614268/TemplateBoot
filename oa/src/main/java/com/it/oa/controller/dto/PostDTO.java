package com.it.oa.controller.dto;

import com.it.oa.entity.PostEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class PostDTO extends PostEntity {
    @ApiModelProperty(value = "职位名")
    private String postLevelName;
    @ApiModelProperty(value = "职位类别名称")
    private Boolean postLevelTypeName;
}
