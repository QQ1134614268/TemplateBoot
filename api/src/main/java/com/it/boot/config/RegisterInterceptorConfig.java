package com.it.boot.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//通过改变注册的顺序可以看到拦截器执行顺序发生了改变。 
//拦截器拦截的请求路径要注意，很容易进坑，/* 拦截一级路径， /**拦截多级路径，不注意很容易出现拦截器失效的情况。 
//拦截器相当与包围着controller执行，所以拦截器做权限过滤、日志统计等工作是相当方便。
@Component
public class RegisterInterceptorConfig implements WebMvcConfigurer {

    /**
     * 重写添加拦截器方法并添加配置拦截器
     *
     * @param registry Register
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**", "/api/**");
    }
}