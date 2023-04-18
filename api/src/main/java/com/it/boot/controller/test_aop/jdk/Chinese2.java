package com.it.boot.controller.test_aop.jdk;

import org.springframework.stereotype.Component;

@Component
public class Chinese2 implements Person {
    @Timer
    @Override
    public void sayHello(String name) {
        System.out.println("-- sayHello()--");
    }

    public void eat(String food) {
        System.out.println("我正在吃：" + food);
    }
}