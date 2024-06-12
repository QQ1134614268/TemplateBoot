package com.it.jiangxin.config.enum1;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @date 2023-02-01 09:34
 */
@Schema(name = "账号状态")
public enum AccountEnum implements IEnumDb {
    normal("normal", "1", "正常"),
    cancel("cancel", "2", "注销"),
    un_using("un_using", "3", "停用"),
    forbidden("forbidden", "4", "禁止"),
    ;

    public final String uniCode;
    public final String value;
    public final String label;

    AccountEnum(String uniCode, String value, String label) {
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
