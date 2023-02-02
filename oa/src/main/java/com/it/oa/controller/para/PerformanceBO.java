package com.it.oa.controller.para;

import com.it.oa.entity.PerformanceIndexEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PerformanceBO implements Serializable {
    @ApiModelProperty(value = "考核类型", example = "", required = true)
    private String cycle;
    @ApiModelProperty(value = "被考核人", example = "1", required = true)
    private Integer userId;
    @ApiModelProperty(value = "名称", example = "1", required = true)
    private String assessmentName;
    @ApiModelProperty(value = "指标", example = "", required = true)
    private List<PerformanceIndexEntity> list;
}

