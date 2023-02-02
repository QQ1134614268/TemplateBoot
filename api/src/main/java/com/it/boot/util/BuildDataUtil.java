package com.it.boot.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class BuildDataUtil {
    public static final int LENGTH = 8;
    // 生成数据 , 数据类型, 字段注释, 字段名, 长度-大小边界, 前缀-后缀,
    // 嵌套 xx.xx.bb
    public final static Integer length = 8;
    public final static Integer numMax = 10000;
    public final static String prefix = "test_";
    public final static String suffix = "_suffix";
    public final static Random random = new Random();

    public static <T> T createData(Class<T> clazz) {
        List<Field> fields = new ArrayList<>();
        ReflectionUtil.getAllFieldsV2(clazz, fields);
        // List<Field> fields = getAllFieldsV1(clazz);
        T target;
        try {
            target = clazz.newInstance();
            for (Field field : fields) {
                int len = Integer.toBinaryString(field.getModifiers()).length();
                if (field.getModifiers() >= 16 && Integer.toBinaryString(field.getModifiers()).charAt(len - 5) == '1') {
                    // field 如果有final修饰符 , 直接return ; 已经初始化的
                    continue;
                }
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object value = getValue(field);

                field.set(target, value);
                field.setAccessible(flag);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return target;
    }

    public static Object getValue(Field field) {
        return getValue(field.getType());
    }

    public static Object getValue(Class<?> field) {

        if (field == int.class || field == Integer.class) {
            return getRandomInt();
        }
        if (field == double.class || field == Double.class) {
            return random.nextDouble();
        }
        if (field == boolean.class || field == Boolean.class) {
            return random.nextBoolean();
        }
        if (field == short.class || field == Short.class) {
            return random.nextInt();
        }
        if (field == long.class || field == Long.class) {
            return random.nextLong();
        }
        if (field == float.class || field == Float.class) {
            return random.nextFloat();
        }
        if (field == char.class || field == Character.class) {
            return StringUtil.codes.charAt(random.nextInt(StringUtil.codes.length()));
        }
        if (field == byte.class || field == Byte.class) {
            byte[] bytes = new byte[LENGTH];
            random.nextBytes(bytes);
            return bytes;
        }
        if (field == String.class) {
            return getRandomString(field.getName());
        }
        if (field == Date.class) {
            // return new Date(System.currentTimeMillis());
            return new Date();
        }
        if (field == BigDecimal.class) {
            return BigDecimal.valueOf(random.nextDouble());
        }
        return null;
    }

    public static int getRandomInt() {
        return random.nextInt(10000);
    }

    public static String getRandomString(String name) {
        // undo 生成数据策略 字段名(name,email),字段类型,长度,范围(数字),唯一,枚举值,随机值 "test"  email, id, name, uni,
        if (name == null) {
            return "test_" + StringUtil.randomText(LENGTH);
        }
        if (name.contains("email")) {
            return StringUtil.randomText(LENGTH) + "@qq.com";
        }
        if (name.contains("id")) {
            return UUID.randomUUID().toString();
        }
        if (name.contains("name")) {
            return StringUtil.randomText(LENGTH);
        }
        if (name.contains("uni")) {
            return UUID.randomUUID().toString();
        }
        return "test_" + StringUtil.randomText(LENGTH);
    }


    // 场景: 函数得到结果-> 输出到环境中, 作为标识, 供另一个函数使用, 且可以
    // a.b.c = 12
    public void toMap(String filedComment, String filedName) {

    }
}
