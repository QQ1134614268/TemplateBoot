package com.it.sim.design;


public class TestAdapter {

    static class Source {
        public void method1() {
            System.out.println("This is original method...");
        }
    }

    interface TargetAble {

        /**
         * 与原类中的方法相同
         */
        void method1();

        /**
         * 新类的方法
         */
        void method2();
    }

    static class Adapter extends Source implements TargetAble {

        @Override
        public void method2() {
            System.out.println("This is the TargetAble method...");
        }
    }

    public static void main(String[] args) {
        TargetAble targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
} 