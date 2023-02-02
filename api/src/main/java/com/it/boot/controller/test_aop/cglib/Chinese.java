package com.it.boot.controller.test_aop.cglib;

import org.springframework.stereotype.Component;

@Component
public class Chinese {

    @Timer
    public void sayHello(String name) {
        System.out.println("-- sayHello() --");
    }

    public void eat(String food) {
        System.out.println("我正在吃：" + food);
    }
}