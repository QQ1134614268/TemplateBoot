package com.it.oa.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class JwtUtil {
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userId";
    public static final String LOGIN_TERMINAL = "loginTerminal";
    static String secret = "aaaa_bbbb_cccc";

    public static String toToken(Integer id, String userName) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(USER_ID, id)
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
        assert token != null;
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_NAME).asString();
    }

    public static Integer getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asInt();
    }

    public static Integer getUserId() {
        String token = getToken();
        assert token != null;
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asInt();
    }

    public static Integer getUserIdNullable() {
        try {
            String token = getToken();
            assert token != null;
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(USER_ID).asInt();
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
        tokenObj.setUserId(jwt.getClaim(USER_ID).asInt());
        tokenObj.setUserName(jwt.getClaim(USER_NAME).asString());
        tokenObj.setLoginTerminal(jwt.getClaim(LOGIN_TERMINAL).asString());
        return tokenObj;
    }

    public static String getToken() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return (String) subject.getPrincipal();
        // HttpServletRequest request =  ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static Integer verify(String token) {
        // Algorithm algorithm = Algorithm.HMAC256(secret);
        // JWTVerifier verifier = JWT.require(algorithm)
        //         .withClaim("userName", username)
        //         .build();
        // DecodedJWT jwt = verifier.verify(token);
        return null;
    }

    @Data
    public static class Token {
        private Integer userId;
        private String userName;
        private String loginTerminal;
        private Integer companyId;
    }

}
