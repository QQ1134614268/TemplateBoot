package com.it.boot.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.it.boot.config.Conf;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class JwtUtil {
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userId";
    public static final String DEPT_ID = "deptId";
    public static final String LOGIN_TERMINAL = "loginTerminal";
    private static String secret;

    @Value("${secret:abc@123}")
    public void setSecret(String secret) {
        JwtUtil.secret = secret;
    }

    public static String toToken(Integer id, String userName, Integer deptId) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(USER_ID, id)
                .withClaim(DEPT_ID, deptId)
                .withClaim(USER_NAME, userName)
                .withClaim(LOGIN_TERMINAL, "PC")
                // .withExpiresAt(date)
                .sign(algorithm);
    }

    public static String getUserName(String token) {

        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_NAME).asString();
    }

    public static String getUserName() {
        String token = getToken();
        Assertions.assertNotNull(token);
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_NAME).asString();
    }

    public static Integer getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asInt();
    }

    public static Long getUserId() {
        String token = getToken();
        Assertions.assertNotNull(token);
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asLong();
    }

    public static Long getDeptId() {
        String token = getToken();
        Assertions.assertNotNull(token);
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(DEPT_ID).asLong();
    }

    public static Long getUserIdNullable() {
        try {
            String token = getToken();
            Assertions.assertNotNull(token);
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USER_ID).asLong();
        } catch (Exception e) {
            return null;
        }
    }

    public static Token decode() {
        Token tokenObj = new Token();
        String token = getToken();
        if (token == null) {
            return tokenObj;
        }
        DecodedJWT jwt = JWT.decode(token);
        tokenObj.setUserId(jwt.getClaim(USER_ID).asLong());
        tokenObj.setDeptId(jwt.getClaim(DEPT_ID).asLong());
        tokenObj.setUserName(jwt.getClaim(USER_NAME).asString());
        tokenObj.setLoginTerminal(jwt.getClaim(LOGIN_TERMINAL).asString());
        return tokenObj;
    }

    public static String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        return request.getHeader(Conf.AUTHORIZATION);
    }

    @Data
    public static class Token {
        private Long userId;
        private Long deptId;
        private String userName;
        private String loginTerminal;
        private Integer companyId;
    }

}
