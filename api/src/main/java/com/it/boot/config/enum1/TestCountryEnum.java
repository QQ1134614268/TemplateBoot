package com.it.boot.config.enum1;

/**
 * @date 2022-12-15 14:44
 */
public enum TestCountryEnum {
    China("China", "中国", "Country"),
    USA("USA", "美国", "Country");

    private final String groupCode;
    private Integer code;
    private final String value;
    private final String label;
    private Integer sort;
    private String note;
    private String status;
    private Long parentId;

    TestCountryEnum(String value, String label, String groupCode) {
        this.value = value;
        this.label = label;
        this.groupCode = groupCode;
    }
}
