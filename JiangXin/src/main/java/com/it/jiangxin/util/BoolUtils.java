package com.it.jiangxin.util;

import java.util.Objects;

public class BoolUtils {
    // todo
    public static boolean toBool(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof String) {
            return !Objects.equals(o, "");
        }
        return true;
    }
}
