package com.it.sim.classloader;

// https://blog.csdn.net/huazai30000/article/details/85296671
// https://blog.csdn.net/u010841296/article/details/89731566
public class ClassLoaderParentMain {

    public static void main(String[] args) {
        ClassLoader ClassLoader1 = ClassLoaderParentMain.class.getClassLoader();
        ClassLoader ClassLoader2 = ClassLoader1.getParent();
        ClassLoader ClassLoader3 = ClassLoader2.getParent();
        System.out.println(ClassLoader1);
        System.out.println(ClassLoader2);
        System.out.println(ClassLoader3);
    }
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