package com.it.boot.config.excel.excel2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//   https://blog.csdn.net/u011521890/article/details/70815640
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface ExcelExport {

    String columnName(); // 处理表格头

    int position(); // 该属性位置
}
