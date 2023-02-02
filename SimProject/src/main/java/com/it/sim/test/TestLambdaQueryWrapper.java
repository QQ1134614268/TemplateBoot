package com.it.sim.test;

/*
 * @date 2022-11-22 19:27
 */
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import lombok.Data;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@Data
public class TestLambdaQueryWrapper {
    // mybatis-plus LambdaQueryWrapper的实现原理和lambda的序列化问题
    // 参考: https://blog.csdn.net/leisurelen/article/details/105980615
    private String fieldA;

    public static void main(String[] args) throws Exception {
        SerializedLambda serializedLambda = doSFunction(TestLambdaQueryWrapper::getFieldA);
        System.out.println("方法名：" + serializedLambda.getImplMethodName());
        System.out.println("类名：" + serializedLambda.getImplClass());
        System.out.println("serializedLambda：" + JSON.toJSONString(serializedLambda));
    }

    private static <T, R> SerializedLambda doSFunction(SFunction<T, R> func) throws Exception {
        // 直接调用writeReplace
        Method method = func.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        //反射调用
        return (SerializedLambda) method.invoke(func);
    }
}

