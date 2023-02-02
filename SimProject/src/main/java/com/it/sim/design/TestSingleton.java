package com.it.sim.design;

public class TestSingleton {
    // 饿汉模式
    static class Singleton1 {
        private static Singleton1 instance = new Singleton1();

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }

    // 懒汉 线程不安全
    static class Singleton {

        private static Singleton instance;// 创建一个实例化，有没有类中类？？

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

    }

    // 懒汉加个synchronized
    static class Singleton2 {
        private static Singleton2 instance;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }

    }


    enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {
        }
    }

    static class Singleton7 {
        // 1.加锁 【保证线程安全】
        // 2.双重if 【保证效率】
        // 3.volatile【避免内存可见性引来的问题】

        private volatile static Singleton7 singleton7;

        private Singleton7() {
        }

        public static Singleton7 getSingleton7() {
            if (singleton7 == null) {
                synchronized (Singleton7.class) {
                    if (singleton7 == null) {
                        singleton7 = new Singleton7();
                    }
                }
            }
            return singleton7;
        }
    }

}