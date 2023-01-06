package com.it.boot.controller.test_aop.aspctj;

public aspect TxAspect {
    void around():call(void Hello.sayHello()) {
        System.out.println("开始事务。。。");
        proceed();
        System.out.println("结束事务。。。");
    }
}
