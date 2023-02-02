package com.it.sim.util;

import java.util.Random;

@SuppressWarnings("SpellCheckingInspection")
public class StringUtil {

    public final static String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 获取随机字符串
     *
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
