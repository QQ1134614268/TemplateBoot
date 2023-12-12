package com.it.boot.config.enum1;

public enum ResCodeEnum {
    // 枚举仿枚举表  // 内嵌还是 config/enum包 ? 提级,公用
    RES_SUCCESS(1, "成功"), RES_FAILURE(2, "失败"), RES_EXCEPTION(4, "失败");
    private final int code;
    private final String label;

    ResCodeEnum(int code, String label) {
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
