package com.it.oa.controller.para;

import com.it.oa.config.ConstConf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("日期区间")
public class BasePara implements Serializable {
    @ApiModelProperty(value = "开始时间", required = true)
    @DateTimeFormat(pattern = ConstConf.DATE_FORMAT)
    private Date startTime;
    @ApiModelProperty(value = "结束时间", required = true)
    @DateTimeFormat(pattern = ConstConf.DATE_FORMAT)
    private Date endTime;
}
