package com.it.boot.config.enumeration;

/**
 * @date 2022-12-07 14:53
 */
public enum ResCodeEnum {
    // 枚举仿枚举表  // 内嵌还是 config/enum包 ? 提级,公用
    RES_SUCCESS(1, "成功"), RES_FAILURE(2, "失败"), RES_EXCEPTION(4, "失败");
    private final int code;
    private final String note;

    ResCodeEnum(int code, String note) {
        this.code = code;
        this.note = note;
    }

    public int getCode() {
        return code;
    }

    public String getNote() {
        return note;
    }
}
