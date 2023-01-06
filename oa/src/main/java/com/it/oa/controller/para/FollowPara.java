package com.it.oa.controller.para;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FollowPara {
    @ApiModelProperty(value = "id", example = "1", required = false)
    Integer id;
    @ApiModelProperty(value = "状态", example = "1", required = false)
    Boolean isFollow;
}
