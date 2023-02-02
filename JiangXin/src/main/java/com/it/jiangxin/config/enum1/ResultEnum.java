package com.it.jiangxin.config.enum1;


/**
 * @date 2023-02-01 09:34
 */
public enum ResultEnum implements IEnumDb<AccountEnum> {
    male("success", "成功"),
    female("fail", "失败");

    final String uniCode;
    final String value;

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
