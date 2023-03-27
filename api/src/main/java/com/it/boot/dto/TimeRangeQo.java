package com.it.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @date 2023-03-27 16:57
 */
@Data
public class TimeRangeQo {

    @NotBlank(message = "起始时间不能为空")
    @ApiModelProperty(value = "起始时间", example = "2022-11-29 00:00:00", required = false)
    private String startTime;

    @NotBlank(message = "结束时间不能为空")
    @ApiModelProperty(value = "结束时间", example = "2022-11-30 00:00:00", required = false)
    private String endTime;
}
