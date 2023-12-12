package com.it.boot.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum SexEnum implements IEnumDb {

    male("1", "男"),
    female("2", "女"),
    unknown("0", "未知");

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
