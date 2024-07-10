package com.it.boot.entity.qo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.boot.config.Conf;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @date 2023-04-28 18:09
 */
@Data
public class TestDateQo {

    @DateTimeFormat(pattern = Conf.DATE_FORMAT)
    @JsonFormat(pattern = Conf.DATE_TIME_FORMAT)
    // @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date datetime;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

}
