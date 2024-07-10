package com.it.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.boot.config.Conf;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
    @Schema(example = "1")
    private Integer id;

    // @JsonFormat(pattern = Conf.DATE_TIME_FORMAT, timezone = "GMT+8")
    @Schema(example = "2022-10-10 10:10:10")
    private Date date;

    @Schema(example = "2022-10-10 10:10:10")
    private java.sql.Date sqlDate;

    @Schema(example = "2022-10-10 10:10:10")
    private java.sql.Time sqlTime;

    @Schema(example = "2022-10-10 10:10:10")
    private Timestamp sqlTimestamp;

    @Schema(example = "2022-10-10 10:10:10")
    private String dateTimeStr;

    @Schema(example = "2022-10-10 10:10:10")
    private LocalDate localDate;

    @Schema(example = "2022-10-10 10:10:10")
    private LocalDateTime localDateTime;

}
