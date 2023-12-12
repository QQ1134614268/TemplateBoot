package com.it.boot.config.excel.excel1.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelValidV2 {
    boolean nullable() default true;

    int min();

    int max();

    int length();

    int example();
}

