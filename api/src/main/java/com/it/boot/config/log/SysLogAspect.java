package com.it.boot.config.log;

import com.it.boot.config.jwt.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SysLogAspect {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private OperationLogService operationLogService;

    @Around("@annotation(Log)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行方法
        Object result = joinPoint.proceed();

        OperationLogEntity vo = new OperationLogEntity();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);

        if (logAnnotation != null) {
            // 注解上的描述
            vo.setAction(logAnnotation.value());
        }
        vo.setUrlLink(httpServletRequest.getRequestURI());
        vo.setIp(httpServletRequest.getRemoteHost());

        JwtUtil.Token obj = JwtUtil.decode();
        vo.setLoginTerminal(obj.getLoginTerminal());
        vo.setUserName(obj.getUserName());
        vo.setUserId(obj.getUserId());
        vo.setOperationTime(new Date());

        operationLogService.save(vo);
        return result;
    }
}
