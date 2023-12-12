package com.it.boot.config.enum1;


/**
 * @date 2023-02-01 09:34
 */
public enum GroupCodeEnum implements IEnumDb {
    SexEnum("1", "性别枚举"),
    AccountEnum("3", "账号枚举");

    final String value;
    final String label;

    GroupCodeEnum(String value, String label) {
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
