package com.it.boot.config.excel.excel1.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Map {


}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelValidV2 {
    boolean nullAble() default true;

    int min();

    int max();

    int length();

    int example();

    Map de();
    // 字符 长度, 空,
    // 整数 最大 最小

}

