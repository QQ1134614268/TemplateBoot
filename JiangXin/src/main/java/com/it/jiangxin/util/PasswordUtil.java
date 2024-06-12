package com.it.jiangxin.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    public static String desPassword(String password) {
        try {
            // 获取 SHA-256 MessageDigest 实例
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 更新要加密的数据
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // 完成哈希计算后，将结果转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // SHA-256 应该总是可用的
        }
    }

    public static void main(String[] args) {
        String original = "test";
        // 打印结果
        System.out.println(desPassword(original));
    }
}