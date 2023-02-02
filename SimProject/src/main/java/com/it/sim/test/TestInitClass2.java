package com.it.sim.test;

import lombok.Data;

// 静态代码块 - 动态代码块 构造方法
@Data
public class TestInitClass2 {
    String name = "mo";
    int age = 21;

    public TestInitClass2() {
        System.out.println("执行默认构造方法");
    }

    {
        System.out.println("执行动态初始化块");
    }

    static {
        System.out.println("执行静态初始化块");
    }

    public TestInitClass2(String name) {
        System.out.println("参为name的构造"+ name);
    }

    public void AA() {

    }

    public static void main(String[] args) throws Exception {
        String classFullName = TestInitClass2.class.getName();
        System.out.println(classFullName);
        Class.forName(classFullName).newInstance(); // 静态代码块
        System.out.println("==========================");
        // A a = new A();// 静态代码块，动态，构造方法
        /*
         * 如果调用Class.forName("A",false,this.getClass().getClassLoader()); 就会发现只加载不初始化static块没
         * 有执行，什么没有输出，所以网上很多说静态块代码在类加载时执行不准确的，其实还是在初始化后执行
         */
        // Class.forName("完整类名").newInstance();的用法相当于直接new();
        // A a=new A();
    }
}
