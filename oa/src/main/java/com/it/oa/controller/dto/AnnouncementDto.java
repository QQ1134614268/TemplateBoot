package com.it.oa.controller.dto;

import com.it.oa.entity.AnnouncementEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AnnouncementDto extends AnnouncementEntity {
    @ApiModelProperty(value = "类型名称", example = "test_1", required = true)
    private String typeName;
}
