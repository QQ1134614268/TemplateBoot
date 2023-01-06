package com.it.boot.controller.test_aop.aspctj;

public class Hello {
    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Hello h = new Hello();
        h.sayHello();
    }
}
// ajc -d . Hello.java TxAspect.aj