package com.it.jiangxin.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum SexEnum implements IEnumDb<SexEnum> {


    male("male", "男"),
    female("female", "女"),
    unknown("unknown", "未知");

    final String uniCode;
    final String value;

    public SexEnum[] values2() {
        return values();
    }

    SexEnum(String uniCode, String value) {
        this.uniCode = uniCode;
        this.value = value;
    }

    @Override
    public String getUniCode() {
        return uniCode;
    }

    @Override
    public String getValue() {
        return value;
    }
}
