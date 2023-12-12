package com.it.boot.entity.qo;

import com.it.boot.config.Conf;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @date 2023-03-27 16:57
 */
@Data
public class TimeRangeQo {

    @ApiModelProperty(value = "起始时间", example = "2022-11-29 00:00:00")
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date startTime;

    @ApiModelProperty(value = "结束时间", example = "2022-11-30 00:00:00")
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date endTime;
}
