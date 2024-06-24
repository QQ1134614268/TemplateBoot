package com.it.sim.test;

import org.junit.Test;

import java.util.Arrays;

enum SexEnum {

    male("1", "男"),
    female("2", "女"),
    unknown("0", "未知"),
    ;

    final String value;
    final String label;

    SexEnum(String value, String label) {
        this.value = value;
        this.label = label;
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
        System.out.println(clz.getSuperclass() == Enum.class);
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
