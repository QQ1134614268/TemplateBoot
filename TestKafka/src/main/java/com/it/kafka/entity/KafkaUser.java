package com.it.kafka.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.kafka.config.ConstConf;
import lombok.Data;

import java.time.LocalDate;

@Data
public class KafkaUser {
    private Long id;

    private String name;

    private Integer age;

    @JsonFormat(pattern = ConstConf.YYYY_MM_DD, timezone = "GMT+8")
    private LocalDate birthDay;
}
