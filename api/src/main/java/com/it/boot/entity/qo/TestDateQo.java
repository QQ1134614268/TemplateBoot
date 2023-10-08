package com.it.boot.entity.qo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.boot.config.Conf;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @date 2023-04-28 18:09
 */
@Data
public class TestDateQo {

    private Date datetime;

    @DateTimeFormat(pattern = Conf.DATE_FORMAT)
    private Date datetimeYmt;

    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date datetimeYmtHms;

    private Date jsonFormat;

    @JsonFormat(pattern = Conf.DATE_FORMAT)
    private Date jsonFormatYmt;

    @JsonFormat(pattern = Conf.DATE_TIME_FORMAT)
    private Date jsonFormatYmtHms;

}
