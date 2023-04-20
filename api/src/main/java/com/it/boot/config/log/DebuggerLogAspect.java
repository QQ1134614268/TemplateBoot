package com.it.boot.config.log;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class DebuggerLogAspect {
    @Around("@annotation(com.it.boot.config.log.DebuggerLog)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(123);
        // 执行方法
        Object[] args = joinPoint.getArgs();
        log.info("参数: {}", JSON.toJSONString(args));
        // 执行方法
        Object result = joinPoint.proceed();
        log.info("返回值: {}", JSON.toJSONString(result));
        return result;
    }

    static class Test {
        @DebuggerLog // 不起作用: 注解使用动态代理, 需要增强后的proxyClass, 环绕方法就不会执行,注解不生效; 使用@Autowired,获取proxyClass;
        public int add(int a, int b) {
            return a + b;
        }

        public static void main(String[] args) {
            System.out.println(new Test().add(1, 2));
        }
    }
}
