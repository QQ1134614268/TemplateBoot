package com.it.boot.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {
    String title() default "";
    String type() default "";// 101 102 ...
}
