package com.cloud.base;

import lombok.Getter;

@Getter
public enum ResCodeEnum {
    SUCCESS(1, "成功"),
    FAILURE(2, "失败"),
    ;

    final Integer value;

    final String label;

    ResCodeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }


}
