package com.it.boot.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum SexEnum implements IEnumDb {

    MALE("1", "男"),
    FEMALE("2", "女"),
    UNKNOWN("0", "未知");

    final String value;
    final String label;

    SexEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
