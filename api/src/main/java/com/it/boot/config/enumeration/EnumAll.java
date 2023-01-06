package com.it.boot.config.enumeration;

/**
 * @date 2022-12-15 11:17
 */
public enum EnumAll {
    Group_Res(1, ""),
    Group_user_state(2, ""),

    RES_SUCCESS(1, "成功"),
    RES_FAILURE(2, "失败"),

    user_state_normal(1, ""),
    user_state_forbidden(2, "");



    // 使用id主键还是code?
    private String groupCode; // UserStateEnum
    private Integer code; // RES_SUCCESS
    private String value; // 1
    private String label; // 成功
    private Integer sort; //
    private String note;
    private String status;
    private Long parentId;
    // private Long parentCode;


    EnumAll(int code, String note) {
        this.code = code;
        this.note = note;
    }

}
