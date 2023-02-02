package com.it.netty.netty_short.s;


import com.it.netty.netty_short.HelloService;

@RpcService
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}