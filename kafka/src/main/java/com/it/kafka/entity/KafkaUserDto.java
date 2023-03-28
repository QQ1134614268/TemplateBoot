package com.it.kafka.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KafkaUserDto extends KafkaUser {
    private String address2;
}
