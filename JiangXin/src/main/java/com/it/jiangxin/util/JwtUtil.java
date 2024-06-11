package com.it.jiangxin.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.it.jiangxin.config.constant.ConstConf;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtil {
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userId";
    private static String secret;

    @Value("${secret:abc@123}")
    public void setSecret(String secret) {
        JwtUtil.secret = secret;
    }

    public static String toToken(Integer id, String userName) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(USER_ID, id)
                .withClaim(USER_NAME, userName)
                .withExpiresAt(new Date())
                .sign(algorithm);
    }

    public static String getUserName(String token) {

        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_NAME).asString();
    }

    public static String getUserName() {
        String token = getToken();
        if (token == null) {
            return null;
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_NAME).asString();
    }

    public static Integer getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asInt();
    }

    public static Integer getUserId() {
        String token = getToken();
        if (token == null) {
            return null;
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asInt();
    }

    public static Token decode() {
        Token tokenObj = new Token();
        String token = getToken();
        if (token == null) {
            return tokenObj;
        }
        DecodedJWT jwt = JWT.decode(token);
        tokenObj.setUserId(jwt.getClaim(USER_ID).asInt());
        tokenObj.setUserName(jwt.getClaim(USER_NAME).asString());
        return tokenObj;
    }

    public static String getToken() {
        // 优化? 注入 HttpServletRequest
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        return request.getHeader(ConstConf.AUTHORIZATION);
    }

    @Data
    public static class Token {
        private Integer userId;
        private String userName;
    }
}
