package com.it.springdoc.config;

import lombok.Getter;

@Getter
public enum StatusEnum {
    ENABLED("已启用"),
    DISABLED("已禁用");

    private final String desc;

    StatusEnum(String desc) {
        this.desc = desc;
    }
}