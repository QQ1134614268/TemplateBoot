package com.it.jiangxin.config;

import com.it.jiangxin.entity.LogEntity;
import com.it.jiangxin.service.LogService;
import com.it.jiangxin.util.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class SysLogAspect {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private LogService logService;

    @Around("@annotation(com.it.jiangxin.config.Log)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行方法
        Object result = joinPoint.proceed();

        LogEntity vo = new LogEntity();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);

        if (logAnnotation != null) {
            // 注解上的描述
            vo.setTitle(logAnnotation.title());
            vo.setType(logAnnotation.type());
        }
        vo.setUrlLink(httpServletRequest.getRequestURI());
        vo.setIp(httpServletRequest.getRemoteHost());

        vo.setUserName(JwtUtil.getUserName());
        vo.setCreateBy(JwtUtil.getUserId());

        logService.save(vo);
        return result;
    }
}
