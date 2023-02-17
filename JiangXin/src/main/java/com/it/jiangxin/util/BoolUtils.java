package com.it.jiangxin.util;

import java.util.Collection;

public class BoolUtils {
    public static boolean toBool(Object target) {
        if (target == null)
            return false;
        if (target instanceof String)
            return ((String) target).length() != 0;
        if (target instanceof Collection)
            return ((Collection<?>) target).size()!= 0;
        if (target instanceof Number)
            return ((Number) target).doubleValue() != 0d;
        if (target instanceof Boolean)
            return (Boolean) target;
        return true;
    }
}
