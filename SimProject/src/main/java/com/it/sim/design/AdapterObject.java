package com.it.sim.design;

public class AdapterObject {
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
            System.out.println("This is the targetAble method...");
        }
    }

    // 基本思路和类的适配器模式相同，只是将Adapter 类作修改，这次不继承Source 类，而是持有Source 类的实例，以达到解决兼容性的问题。
    static class Wrapper2 implements TargetAble {

        private Source source;

        public Wrapper2(Source source) {
            super();
            this.source = source;
        }

        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            System.out.println("This is the targetAble method...");
        }
    }

    public static void main(String[] args) {
        Source source = new Source();
        TargetAble targetable = new Wrapper2(source);
        targetable.method1();
        targetable.method2();
    }
}