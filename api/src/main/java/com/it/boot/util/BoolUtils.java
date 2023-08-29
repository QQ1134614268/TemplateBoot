package com.it.boot.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class BoolUtils {
    public static boolean toBool(Object target) {
        if (target == null)
            return false;
        if (target instanceof String)
            return ((String) target).length() != 0;
        if (target instanceof Collection)
            return !((Collection<?>) target).isEmpty();
        if (target instanceof Map)
            return !((Map<?, ?>) target).isEmpty();
        if (target instanceof Number)
            return ((Number) target).doubleValue() != 0d;
        if (target instanceof Boolean)
            return (Boolean) target;
        return true;
    }

    public static boolean toBool(Object... target) {
        for (Object o : target) {
            if (!toBool(o)) return false;
        }
        return true;
    }

    public static boolean any(Object... target) {
        for (Object o : target) {
            if (toBool(o)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(toBool(0.0));
        System.out.println(toBool(""));
        System.out.println(toBool(false));
        System.out.println(toBool(new ArrayList<>()));
        System.out.println(toBool(new Object()));
    }
}
