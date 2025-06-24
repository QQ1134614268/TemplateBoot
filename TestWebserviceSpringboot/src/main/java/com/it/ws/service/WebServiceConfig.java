package com.it.ws.service;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Resource
    private Bus bus;

    @Resource
    private UserService userService;

    /**
     * 如果有多个服务需要暴露，需定义多个EndpointImpl 的Bean，并关联到对应的 服务 ，绑定到指定路径
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService);
        // 设置入口拦截器，拦截器实现 org.apache.cxf.interceptor.Interceptor 接口即可
//        endpoint.getInInterceptors().add(new CustomInterceptor());
        endpoint.publish("/user");
        return endpoint;
    }
}
