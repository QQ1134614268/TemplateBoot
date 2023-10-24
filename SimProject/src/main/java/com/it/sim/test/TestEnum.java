package com.it.sim.test;

import org.junit.Test;

import java.util.Arrays;

enum SexEnum {


    male("male", "1", "男"), female("female", "2", "女"), unknown("unknown", "0", "未知");

    final String uniCode;
    final String value;
    final String label;

    SexEnum(String uniCode, String value, String label) {
        this.uniCode = uniCode;
        this.value = value;
        this.label = label;
    }

    public String getUniCode() {
        return uniCode;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}

public class TestEnum {
    @Test
    public void eg1() {
        Class<?> clz = SexEnum.class;
        System.out.println(clz.getSuperclass() ==Enum.class);
        System.out.println(clz.isEnum());
        // clz.enumConstants
        // clz.enumConstantDirectory
        // clz.getEnumConstants()
        // clz.enumConstantDirectory()
        // clz.getEnumConstantsShared()
        Object[] arr = clz.getEnumConstants();
        Arrays.stream(arr).forEach(System.out::println);
    }

}
