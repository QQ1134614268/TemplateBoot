package com.it.sim.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类和被代理类共同实现的接口
 */
interface IService {
    void service();
}

class Service implements IService {

    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}

class Service2 implements IService {

    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作2");
    }
}

class ServiceInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object srcObject;

    public ServiceInvocationHandler(Object srcObject) {
        this.srcObject = srcObject;
    }

    @Override
    public Object invoke(Object proxyObj, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行" + method.getName() + "方法");
        // 执行原对象的相关操作，容易忘记
        Object returnObj = method.invoke(srcObject, args);
        System.out.println(method.getName() + "方法执行完毕");
        return returnObj;
    }
}

public class ProxyDynamic {
    public static void main(String[] args) {
        IService service = new Service();
        Class<? extends IService> clazz = service.getClass();

        IService proxyService = (IService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                new ServiceInvocationHandler(service));
        proxyService.service();

        IService service2 = new Service2();
        Class<?> clazz2 = service2.getClass();
        IService proxyService2 = (IService) Proxy.newProxyInstance(clazz2.getClassLoader(), clazz2.getInterfaces(),
                new ServiceInvocationHandler(service2));
        proxyService2.service();
    }
}