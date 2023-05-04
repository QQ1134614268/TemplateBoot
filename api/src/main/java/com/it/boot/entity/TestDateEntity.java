package com.it.boot.entity;

import com.it.boot.config.Conf;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity(name = "test_date_t")
public class TestDateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "1")
    private Integer id;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private Date date;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private java.sql.Date sqlDate;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private java.sql.Time sqlTime;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private Timestamp sqlTimestamp;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private String dateTimeStr;

    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private LocalDate localDate;

    @DateTimeFormat(pattern = Conf.DATE_TIME_FORMAT)
    @ApiModelProperty(example = "2022-10-10 10:10:10")
    private LocalDateTime localDateTime;

}
