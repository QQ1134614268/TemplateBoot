package com.it.sim.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //这个类class的路径
        // ClassLoaderMain.class.getResource("").getPath();
        String classPath = Class.class.getResource("/").getPath() + "Log.class";
        MyClassLoader myClassLoader = new MyClassLoader(classPath);
        //类的全称
        String packageNamePath = Log.class.getName();
        //加载Log这个class文件
        Class<?> Log = myClassLoader.loadClass(packageNamePath);

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }
}