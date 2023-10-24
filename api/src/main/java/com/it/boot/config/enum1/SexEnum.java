package com.it.boot.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum SexEnum implements IEnumDb {


    male("male", "1", "男"),
    female("female", "2", "女"),
    unknown("unknown", "0", "未知");

    final String uniCode;
    final String value;
    final String label;

    SexEnum(String uniCode, String value, String label) {
        this.uniCode = uniCode;
        this.value = value;
        this.label = label;
    }

    @Override
    public String getUniCode() {
        return uniCode;
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
