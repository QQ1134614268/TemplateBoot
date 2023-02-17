package com.it.jiangxin.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum GroupCodeEnum implements IEnumDb<GroupCodeEnum> {
    SexEnum(SexEnum.class.getSimpleName(), "性别枚举"),
    ResultEnum(ResultEnum.class.getSimpleName(), "结果类型枚举"),
    AccountEnum(AccountEnum.class.getSimpleName(), "账号枚举");

    final String uniCode;
    final String value;

    GroupCodeEnum(String uniCode, String value) {
        this.uniCode = uniCode;
        this.value = value;
    }

    public GroupCodeEnum[] values2() {
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
