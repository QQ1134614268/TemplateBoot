package com.it.boot.entity.qo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.it.boot.config.Conf;
import com.it.boot.entity.UserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class UserQo extends UserEntity {

    @ApiModelProperty(value = "搜索")
    private String search;

    @ApiModelProperty(value = "起始时间", example = "2022-11-29 00:00:00", required = false)
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date startTime;

    @ApiModelProperty(value = "结束时间", example = "2022-11-30 00:00:00", required = false)
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date endTime;


    protected List<OrderItem> orders;

    protected String orderCreateTime;

}
