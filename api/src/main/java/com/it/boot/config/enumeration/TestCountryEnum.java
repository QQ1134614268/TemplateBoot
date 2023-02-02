package com.it.boot.config.enumeration;

/**
 * @date 2022-12-15 14:44
 */
public enum TestCountryEnum {
    China("China", "中国", "Country"),
    USA("USA", "美国", "Country");

    // 使用id主键还是code?
    private String groupCode; // UserStateEnum
    private Integer code; // RES_SUCCESS
    private String value; // 1
    private String label; // 成功
    private Integer sort; //
    private String note;
    private String status;
    private Long parentId;

    TestCountryEnum(String value, String label, String groupCode) {
        this.value = value;
        this.label = label;
        this.groupCode = groupCode;
    }
}
