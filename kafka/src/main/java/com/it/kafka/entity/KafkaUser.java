package com.it.kafka.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.kafka.config.ConstConf;
import lombok.Data;

import java.util.Date;

@Data
public class KafkaUser {
    private Long id;

    private String name;

    private Integer age;

    // @DateTimeFormat
    @JsonFormat(pattern = ConstConf.YYYY_MM_DD_HH_MM_SS) //, timezone = "GMT+8"
    private Date birthTime;

    private String Introduce;

    private String address;
}
