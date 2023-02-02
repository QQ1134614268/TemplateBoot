package com.it.sim.jvm.javamemory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.ArrayList;
import java.util.List;

// -XX:PermSize=10M -XX:MaxPermSize=10M
public class JavaMethodAreaOOM {
    static class OOMObject {
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    (MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects, objects)
            );
            list.add(enhancer.create());
        }
    }
}
