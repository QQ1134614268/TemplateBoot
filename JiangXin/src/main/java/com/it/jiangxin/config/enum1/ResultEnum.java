package com.it.jiangxin.config.enum1;


/**
 * @date 2023-02-01 09:34
 */
public enum ResultEnum implements IEnumDb<ResultEnum> {
    male("success", "成功"),
    female("fail", "失败");

    final String uniCode;
    final String value;

    public ResultEnum[] values2() {
        return values();
    }

    ResultEnum(String uniCode, String value) {
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
