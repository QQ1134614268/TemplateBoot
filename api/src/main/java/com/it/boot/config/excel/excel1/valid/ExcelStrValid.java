package com.it.boot.config.excel.excel1.valid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Excel导入字符串长度校验</p>
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelStrValid {
    int length() default 0;

    String message() default "文字填写超出长度要求";
}
