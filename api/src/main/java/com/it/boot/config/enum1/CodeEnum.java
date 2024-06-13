package com.it.boot.config.enum1;

public enum CodeEnum {
    SUCCESS(1, "成功"),
    FAILURE(2, "失败"),
    FORBIDDEN(4, "禁止"),
    ;

    final Integer value;

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    final String label;

    CodeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }


}
