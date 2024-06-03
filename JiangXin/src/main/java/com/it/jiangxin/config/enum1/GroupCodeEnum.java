package com.it.jiangxin.config.enum1;

/**
 * @date 2023-02-01 09:34
 */
public enum GroupCodeEnum implements IEnumDb {
    SexEnum(SexEnum.class.getSimpleName(), "1", "性别枚举"),
    ResultEnum(ResultEnum.class.getSimpleName(), "2", "结果类型枚举"),
    AccountEnum(AccountEnum.class.getSimpleName(), "3", "账号枚举"),
    ImgType("IMG_TYPE", "4", "图片分类"),
    ;

    final String uniCode;
    final String value;
    final String label;

    GroupCodeEnum(String uniCode, String value, String label) {
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
