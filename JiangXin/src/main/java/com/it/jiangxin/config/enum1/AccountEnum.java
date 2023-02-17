package com.it.jiangxin.config.enum1;

import io.swagger.annotations.ApiModel;

/**
 * @date 2023-02-01 09:34
 */
@ApiModel(value = "账号状态")
public enum AccountEnum implements IEnumDb<AccountEnum> {
    normal("normal", "正常"),
    cancel("cancel", "注销"),
    un_using("un_using", "停用"),
    forbidden("forbidden", "禁止");

    public final String uniCode;
    public final String value;

    AccountEnum(String uniCode, String value) {
        this.uniCode = uniCode;
        this.value = value;
    }

    public AccountEnum[] values2() {
        return values();
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
