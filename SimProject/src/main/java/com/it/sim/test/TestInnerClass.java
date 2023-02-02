package com.it.sim.test;

public class TestInnerClass {
    public static Object getInner() {
        // 定义一个局部变量
        String str = "哈哈";
//        str = "呵呵"; // 对成员变量进行修改。
        // 定义一个局部内部类
        class Inner {
            // 重写一下Object的toString方法，返回方法中定义的局部变量str
            @Override
            public String toString() {
                return str;
            }
        }
        // 方法返回一个一个内部类对象
        return new Inner();
    }

    // 主函数调用method方法，获得一个内部类对象，调用toString方法
    public static void main(String[] args) {
        Object obj = getInner();
        System.out.println(obj);
    }
}

