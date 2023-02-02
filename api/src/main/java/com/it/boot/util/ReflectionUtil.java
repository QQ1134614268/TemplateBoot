package com.it.boot.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 反射工具类 undo
 */
public class ReflectionUtil {
    // map class 互相转化 json

    public static void getAllFieldsV2(Class clazz, List<Field> fields) {
        if (Object.class == clazz) {
            return;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        fields.addAll(Arrays.asList(declaredFields));
        getAllFieldsV2(clazz.getSuperclass(), fields);
    }

    public static List<Field> getAllFieldsV1(Class clazz) {
        List<Field> ret = new ArrayList<>();
        if (Object.class == clazz) {
            return ret;
        }

        ret.addAll(getAllFieldsV1(clazz.getSuperclass()));

        Field[] declaredFields = clazz.getDeclaredFields();
        ret.addAll(Arrays.asList(declaredFields));
        return ret;
    }


}
