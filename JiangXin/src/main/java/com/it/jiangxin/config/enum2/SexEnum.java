package com.it.jiangxin.config.enum2;

import com.it.jiangxin.config.enum1.AccountEnum;
import com.it.jiangxin.config.enum1.IEnumDb;

import java.util.List;

/**
 * @date 2023-02-01 09:34
 */
public class SexEnum implements IEnumDb<AccountEnum> {
    // 模仿枚举 属性, values keys of方法

    public static final SexEnum male = new SexEnum("male", "男");
    public static final SexEnum female = new SexEnum("female", "女");
    public static final SexEnum unknown = new SexEnum("unknown", "未知");


    public List<SexEnum> values() {
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
