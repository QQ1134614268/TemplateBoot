package com.it.boot.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity(name = "test_date_t")
public class TestDateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户名", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private Date utilDate;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private java.sql.Date sqlDate;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private Time sqlTime;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private Timestamp sqlTimestamp;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private String dateTimeStr;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private LocalDate localDate;
    @ApiModelProperty(value = "用户名", example = "2022-10-10 10:10:10")
    private LocalDateTime localDateTime;

}
