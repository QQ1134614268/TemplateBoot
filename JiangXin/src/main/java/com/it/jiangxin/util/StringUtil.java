package com.it.jiangxin.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class StringUtil {

    public final static String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

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

        if (target instanceof Collections)
            return !CollectionUtils.isEmpty((Collection<?>) target);

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
}
