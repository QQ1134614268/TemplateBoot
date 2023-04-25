package com.it.sim.test.reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;


/**
 * 使用reflect进行转换
 */
public class ReflectConvert {

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    /**
     * 对象转换成字节数组
     *
     * @param obj 对象
     * @return byte[]
     */
    public static byte[] objectToByteArray(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }

        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream())
        ) {
            objectOutputStream.writeObject(obj);
            return new ByteArrayOutputStream().toByteArray();
        }

    }

    /**
     * 字节数组转换成对象
     *
     * @return Object
     */
    public static Object byteArrayToObject(byte[] buffer) throws IOException, ClassNotFoundException {
        if (buffer == null || buffer.length == 0) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer))) {
            return ois.readObject();
        }
    }

}