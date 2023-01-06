package com.it.sim.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    //指定路径
    private String path;

    public MyClassLoader(String classPath) {
        path = classPath;
    }

    /**
     * 重写findClass方法
     *
     * @param name 是我们这个类的全路径
     */
    @Override
    protected Class<?> findClass(String name) {
        Class<?> log = null;
        // 获取该class文件字节码数组
        byte[] classData = new byte[0];
        try {
            classData = getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (classData != null) {
            // 将class的字节码数组转换成Class类的实例
            log = defineClass(name, classData, 0, classData.length);
        }
        return log;
    }

    /**
     * 将class文件转化为字节码数组
     *
     */
    private byte[] getData() throws IOException {

        File file = new File(path);
        if (file.exists()) {
            try (
                    FileInputStream in = new FileInputStream(file);
                    ByteArrayOutputStream out = new ByteArrayOutputStream()
            ) {
                byte[] buffer = new byte[1024];
                int size;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
                return out.toByteArray();
            }
        }
        return null;
    }
}