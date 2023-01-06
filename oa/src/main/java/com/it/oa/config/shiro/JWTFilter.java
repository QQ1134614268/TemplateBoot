package com.it.oa.config.shiro;


import com.google.gson.Gson;
import com.it.oa.config.ApiResult;
import com.it.oa.config.ConstConf;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 处理filter抛出的异常
@Component
public class JWTFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        if (servletRequest instanceof HttpServletRequest) {
            if (((HttpServletRequest) servletRequest).getMethod().equalsIgnoreCase("OPTIONS")) {
                return true;
            }
        }
        try {
            AuthenticationToken token = this.createToken(servletRequest, servletResponse);
            if (token.getPrincipal() == null) {
                handleException(servletResponse, ApiResult.forbidden("未登录"));
                return false;
            }
            this.getSubject(servletRequest, servletResponse).login(token);
        } catch (Exception e) {
            handleException(servletResponse, ApiResult.forbidden("没有权限"));
            return false;
        }
        return true;
    }


    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(ConstConf.AUTHORIZATION);
        return new JWTToken(token);
    }

    private void handleException(ServletResponse response, ApiResult res) throws IOException {
        // 使用 BasicExceptionController
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpStatus.OK.value());
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.getWriter().write(new Gson().toJson(res));
    }
}
