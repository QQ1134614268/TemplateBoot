package com.it.oa.controller.para;

import com.it.oa.entity.CalendarEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PerformanceDTO extends CalendarEntity {
    @ApiModelProperty(value = "分数", example = "1", required = true)
    private Float score;
    @ApiModelProperty(value = "日期", example = "1", required = true)
    private String dateStr;
}

