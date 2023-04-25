package com.it.sim.test.classloader;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

// https://blog.csdn.net/m0_52739267/article/details/125489007
public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //这个类class的路径
        // ClassLoaderMain.class.getResource("").getPath();
        String classPath = Objects.requireNonNull(Class.class.getResource("/")).getPath();
        MyClassLoader myClassLoader = new MyClassLoader(classPath);

        //类的全称
        String packageNamePath = Log.class.getName();
        Class<?> Log = myClassLoader.loadClass(packageNamePath); //加载Log这个class文件

        System.out.println("类加载器是:" + Log.getClassLoader());

        //利用反射获取main方法
        Method method = Log.getDeclaredMethod("main", String[].class);
        Object object = Log.newInstance();
        String[] arg = {"ad"};
        method.invoke(object, (Object) arg);
    }


    @Test
    public void test() {
        // https://blog.csdn.net/u010841296/article/details/89731566
        ClassLoader ClassLoader1 = TestClassLoader.class.getClassLoader();
        ClassLoader ClassLoader2 = ClassLoader1.getParent();
        ClassLoader ClassLoader3 = ClassLoader2.getParent();
        System.out.println(ClassLoader1);
        System.out.println(ClassLoader2);
        System.out.println(ClassLoader3);
    }
    // 核心代码  ClassLoader.loadClass
    // protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    //     synchronized (getClassLoadingLock(name)) { // 首先，检测是否已经加载
    //         Class<?> c = findLoadedClass(name);
    //         if (c == null) {
    //             long t0 = System.nanoTime();
    //             try {
    //                 if (parent != null) { //父加载器不为空则调用父加载器的loadClass
    //                     c = parent.loadClass(name, false);
    //                 } else { //父加载器为空则调用Bootstrap Classloader
    //                     c = findBootstrapClassOrNull(name);
    //                 }
    //             } catch (ClassNotFoundException e) { // ClassNotFoundException thrown if class not found // from the non-null parent class loader
    //             }
    //             if (c == null) { // If still not found, then invoke findClass in order // to find the class.
    //                 long t1 = System.nanoTime(); //父加载器没有找到，则调用findClass
    //                 c = findClass(name); // this is the defining class loader; record the stats sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0); sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1); sun.misc.PerfCounter.getFindClasses().increment();
    //             }
    //         }
    //         if (resolve) { //调用resolveClass()
    //             resolveClass(c);
    //         }
    //         return c;
    //     }
    // }
}