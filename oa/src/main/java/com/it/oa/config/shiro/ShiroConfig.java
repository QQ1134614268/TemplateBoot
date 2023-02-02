package com.it.oa.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 * 1.配置ShiroFilterFactory 2.配置SecurityManager
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置shiro过滤器
     */
    @Bean(name = "myRealm")
    public MyRealm myRealm() {
        MyRealm myShiroRealm = new MyRealm();
        //        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        myShiroRealm.setCachingEnabled(true);
        //        myShiroRealm.setCacheManager(redisCacheManager());
        return myShiroRealm;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // //自定义拦截器
        // Map<String, Filter> filtersMap = new LinkedHashMap<>();
        // filtersMap.put("managerAccessControlFilter", managerAccessControlFilter);
        // shiroFilterFactoryBean.setFilters(filtersMap);

        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/api/user/login", "anon");
        filterChainMap.put("/api/user/getVerificationCode", "anon");
        filterChainMap.put("/api/file/**", "anon");
        filterChainMap.put("/api/test/getUserByShiro", "authc");
        // filterChainMap.put("/**", "anon");
        filterChainMap.put("/api/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        // 添加认证过滤器
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("authc", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置安全管理器
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        //        securityManager.setSessionManager(sessionManager());
        //        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    // 使用注解但是没效果 或者直接全部拦截解决方法
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    // 使用注解但是没效果 或者直接全部拦截解决方法
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}