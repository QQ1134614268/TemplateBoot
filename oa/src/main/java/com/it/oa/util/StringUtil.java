package com.it.oa.util;

import java.util.Collection;
import java.util.Random;

public class StringUtil {

    public final static String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static char UNDERLINE = '_';

    /**
     * 判断字符串是否为空白
     *
     * @param str 字符串
     * @return 判断字符串是否为空白
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    // 字符串,集合,数字
    public static boolean toBool(Object target) {
        if (target == null) {
            return false;
        }

        if (target instanceof String)
            return ((String) target).length() != 0;

        if (target instanceof Collection)
            return !((Collection<?>) target).isEmpty();

        if (target instanceof Number)
            return !target.equals(0);
        return true;
    }

    public static boolean toBool(String str) {
        return str != null && str.length() != 0;
    }

    /**
     * 获取随机字符串
     */
    public static String randomText(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(codes.charAt(random.nextInt(codes.length())));
        }
        return sb.toString();
    }

    public static String toCamelCase(String name) {
        if (null == name) {
            return null;
        }
        if (name.contains(String.valueOf(UNDERLINE))) {
            final int length = name.length();
            final StringBuilder sb = new StringBuilder(length);
            boolean upperCase = false;
            for (int i = 0; i < length; i++) {
                char c = name.charAt(i);

                if (c == UNDERLINE) {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            return sb.toString();
        } else {
            return name;
        }
    }

    public static String upperFirst(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
