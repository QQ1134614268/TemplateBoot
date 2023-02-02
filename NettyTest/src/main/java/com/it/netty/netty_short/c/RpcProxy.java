package com.it.netty.netty_short.c;

import com.it.netty.netty_short.RpcRequest;
import com.it.netty.netty_short.RpcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


@Component
public class RpcProxy implements InvocationHandler {
 
    @Autowired
    private RpcNettyClient rpcNettyClient;
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setParameterTypes(method.getParameterTypes());
 
        RpcResponse rpcResponse = rpcNettyClient.send(rpcRequest);
        return rpcResponse.getResult();
    }
}