package com.it.boot.config.enum1;

public enum CodeEnum {
    SUCCESS(1, "成功"),
    FAILURE(2, "失败"),
    EXCEPTION(4, "异常");
    private final int code;
    private final String label;

    CodeEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
