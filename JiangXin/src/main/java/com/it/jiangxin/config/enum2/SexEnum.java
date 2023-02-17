package com.it.jiangxin.config.enum2;

import com.it.jiangxin.config.enum1.IEnumDb;

/**
 * @date 2023-02-01 09:34
 */
public class SexEnum implements IEnumDb<SexEnum> {
    // 模仿枚举 属性, values keys of方法

    public static final SexEnum male = new SexEnum("male", "男");
    public static final SexEnum female = new SexEnum("female", "女");
    public static final SexEnum unknown = new SexEnum("unknown", "未知");


    public SexEnum[] values2() {
        return null; // todo
    }

    private String uniCode;
    private String value;

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
