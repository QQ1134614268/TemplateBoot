package com.it.sim.design;

public class TestSingleton {

    // 饿汉模式
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

    // 饿汉加个synchronized成懒汉
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

    static class Singleton3 {
        private static Singleton3 instance = new Singleton3();

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            return instance;
        }

    }

    static class Singleton4 {
        private static Singleton4 instance;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            return instance;// return this.instance;???????
        }

    }

    static class Singleton5 {
        private static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {
        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }

    }

    enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {
        }
    }

    static class Singleton7 {
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