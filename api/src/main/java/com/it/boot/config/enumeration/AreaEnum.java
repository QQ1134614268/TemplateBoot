package com.it.boot.config.enumeration;

/**
 * @date 2022-12-07 14:53
 */
public enum AreaEnum {
    RES_SUCCESS(1, "成功"), RES_FAILURE(2, "失败");


    private String groupCode; // UserStateEnum
    private Integer code; // RES_SUCCESS
    private String value; // 1
    private String label; // 成功
    private Integer sort; //
    private String note;
    private String status;
    private Long parentId;
    // private Long parentCode; // 建议, 但是code不唯一


    AreaEnum(int code, String note) {
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
