package com.it.boot.config.enum1;

import lombok.AllArgsConstructor;

/**
 * @date 2022-12-15 14:44
 */
@AllArgsConstructor
public enum TestCityEnum {

    SHENZHEN("SHENZHEN", "深圳", "city"),
    GUANGZHOU("GUANGZHOU", "广州", "city");

    private final String groupCode;
    private Integer code;
    private final String value;
    private final String label;
    private Integer sort;
    private String note;
    private String status;
    private Long parentId;

    TestCityEnum(String value, String label, String groupCode) {
        this.value = value;
        this.label = label;
        this.groupCode = groupCode;
    }
}
