package com.javatribe.apicommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.javatribe.apicommon.interceptor.role.UserType;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Map;

/**
 * @author LiangYonghui
 * @date 2020/10/11 8:58
 * @description
 */
@Slf4j
public class JwtUtil {
    public static final String TOKEN_HEADER = "TokenHeader";
    public static final String SECRET = "amF2YXRyaWJlMjAyMQ==";

    public static String getAdminToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.ADMIN.getType(),UserType.ADMIN.getTypeCode());
        return setDefault(map, SECRET, builder);
    }

    public static String getSuperToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.SUPER.getType(),UserType.SUPER.getTypeCode());
        return setDefault(map, SECRET, builder);
    }

    public static String getUserToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(UserType.USER.getType(),UserType.USER.getTypeCode());
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
     * @param token
     * @return
     */
    public static boolean verify(String token,UserType userType){
        return (userType.getTypeCode() == getToken(token).getClaim(userType.getType()).asInt()) ? true : false;
    }


    /**
     * 获取token中payload,无需解密也可获得
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token){
        return JWT.decode(token);
    }
}
