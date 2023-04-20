package com.it.boot.config.log;

import java.lang.annotation.*;

/**
 * @date 2023-04-20 18:11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DebuggerLog {
}
