package com.it.oa.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Component
public class RegisterInterceptorConfig implements WebMvcConfigurer {
    @Resource
    AuthInterceptor authInterceptor;

    /**
     * 重写添加拦截器方法并添加配置拦截器
     *
     * @param registry Register
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns(
                "/**"
        ).excludePathPatterns(
                "/swagger**/**",
                "/webjars/**",
                "/v3/**",
                "/doc.html"
        );
    }

    // 重点
    //    @Override
    //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //        registry.
    //                addResourceHandler("/swagger-ui/**")
    //                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
    //                .resourceChain(false);
    //    }
}