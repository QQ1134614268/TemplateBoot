package com.it.boot.entity.qo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.it.boot.config.Conf;
import com.it.boot.entity.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQo extends UserEntity {

    @Schema(title = "搜索")
    private String search;

    @Schema(title = "起始时间", example = "2022-11-29 00:00:00")
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date startTime;

    @Schema(title = "结束时间", example = "2022-11-30 00:00:00")
    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date endTime;


    protected List<OrderItem> orders;

    protected String orderCreateTime;

}
