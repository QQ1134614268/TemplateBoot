package com.it.boot.config.enumeration;

/**
 * @date 2022-12-07 14:53
 */
public enum UserStateEnum {
    // 枚举仿枚举表  // 内嵌还是 config/enum包 ? 提级,公用
    RES_SUCCESS(1, "成功"), RES_FAILURE(2, "失败");

    // 省市县

    private String groupCode; // UserStateEnum
    private Integer code; // RES_SUCCESS
    private String value; // 1
    private String label; // 成功
    private Integer sort; //
    private String note;
    private String status;
    private Long parentId;


    UserStateEnum(int code, String note) {
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
