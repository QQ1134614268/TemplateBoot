package com.it.sim.classloader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private String codePath;

    public MyClassLoader(ClassLoader parent, String codePath) {
        super(parent);
        this.codePath = codePath;
    }

    public MyClassLoader(String codePath) {
        this.codePath = codePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        codePath = codePath + name.replace(".", File.separator) + ".class";
        byte[] bytes = new byte[1024];
        int line;
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(codePath)));
             ByteArrayOutputStream bos = new ByteArrayOutputStream()
        ){
            //读取编译后的文件
            while ((line = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, line);
            }
            bos.flush();
            bytes = bos.toByteArray();
            return defineClass(null, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t1 = System.nanoTime();
                //如果包名是com开头的，调用自定义类的findClass方法，否则调用父类的loadClass方法
                if (name.startsWith("com")) {
                    c = this.findClass(name);
                } else {
                    c = this.getParent().loadClass(name);
                }
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}