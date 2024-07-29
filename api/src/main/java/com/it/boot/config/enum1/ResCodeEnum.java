package com.it.boot.config.enum1;

import lombok.Getter;

@Getter
public enum ResCodeEnum {
    SUCCESS(1, "成功"),
    FAILURE(2, "失败"),
    EXCEPTION(4, "异常");
    private final int code;
    private final String label;

    ResCodeEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }
}
