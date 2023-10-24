package com.it.boot.config.enum1;


/**
 * @date 2023-02-01 09:34
 */
public enum ResultEnum implements IEnumDb {
    male("success", "1", "成功"),
    female("fail", "2", "失败");

    final String uniCode;
    final String value;
    final String label;

    ResultEnum(String uniCode, String value, String label) {
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
