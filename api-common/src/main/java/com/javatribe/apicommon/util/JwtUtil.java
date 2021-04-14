package com.javatribe.apicommon.util;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.exception.NoTokenException;
import com.javatribe.apicommon.interceptor.role.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Calendar;
import java.util.Map;

/**
 * @author LiangYonghui
 * @date 2020/10/11 8:58
 * @description
 */
@Slf4j
public class JwtUtil implements HandlerInterceptor {
    public static final String TOKEN_HEADER = "TokenHeader";
    public static final String SECRET = "amF2YXRyaWJlMjAyMQ==";

    public static String getAdminToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.ADMIN.getType(), UserType.ADMIN.getTypeCode());
        return setDefault(map, SECRET, builder);
    }

    public static String getSuperToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.SUPER.getType(), UserType.SUPER.getTypeCode());
        return setDefault(map, SECRET, builder);
    }

    public static String getUserToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.USER.getType(), UserType.USER.getTypeCode());
        return setDefault(map, SECRET, builder);
    }

    private static String setDefault(Map<String, String> map, String secret, JWTCreator.Builder builder) {
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        Calendar instance = Calendar.getInstance();
        //过期时间为2小时
        instance.add(Calendar.SECOND, 60 * 60 * 2);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static boolean verify(String token, UserType userType) {
        int T_SUPER;
        int T_ADMIN;
        int T_USER;
        try {
            T_SUPER = getToken(token).getClaim(UserType.SUPER.getType()).asInt();
        } catch (Exception e) {
            System.out.println("为空了置位-1");
            T_SUPER = -1;
        }
        try {
            T_ADMIN = getToken(token).getClaim(UserType.ADMIN.getType()).asInt();
        } catch (Exception e) {
            System.out.println("为空了置位-1");
            T_ADMIN = -1;
        }
        try {
            T_USER = getToken(token).getClaim(UserType.USER.getType()).asInt();
        } catch (Exception e) {
            System.out.println("为空了置位-1");
            T_USER = -1;
        }
        if (userType.getTypeCode() == UserType.USER.getTypeCode()) {
            return (UserType.SUPER.getTypeCode() == T_SUPER)
                    || (UserType.ADMIN.getTypeCode() == T_ADMIN)
                    || (UserType.USER.getTypeCode() == T_USER);
        } else if (userType.getTypeCode() == UserType.ADMIN.getTypeCode()) {
            return (UserType.SUPER.getTypeCode() == T_SUPER)
                    || (UserType.ADMIN.getTypeCode() == T_ADMIN);
        } else if (userType.getTypeCode() == UserType.SUPER.getTypeCode()) {
            return UserType.SUPER.getTypeCode() == T_SUPER;
        }

        throw new NoTokenException(ApiInfo.FORBIDDEN_REQUEST);
    }


    /**
     * 获取token中payload,无需解密也可获得
     *
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token) {
        try {
            return JWT.decode(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
