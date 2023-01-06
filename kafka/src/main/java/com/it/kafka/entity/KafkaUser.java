package com.it.kafka.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class KafkaUser {
    private Long id;

    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;

    private String Introduce;

    private String address;
}
