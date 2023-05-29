package com.it.kafka.entity;

import org.springframework.data.web.JsonPath;

public interface SomeSample {
    @JsonPath({"$.username", "$.user.name"})
    String getUsername();
}