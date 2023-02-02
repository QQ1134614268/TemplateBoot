package com.it.boot.config.excel.excel2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExcelImport {

    String columnName();// 表格头 的名

    boolean emptyAble() default true;
}