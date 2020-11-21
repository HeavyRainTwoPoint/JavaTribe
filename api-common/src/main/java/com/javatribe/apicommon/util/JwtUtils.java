package com.javatribe.apicommon.util;

import com.javatribe.apicommon.shiro.entity.JwtToken;

import java.util.Map;

/**
 * @Author lyr
 * @create 2020/10/25 0:31
 */
public class JwtUtils {


    /**
     *
     * @param jwtData
     * @param ttl
     * @return
     */
    public static String sign(Map<String,String> jwtData,long ttl) {
        return JwtAdapter.createJWT(jwtData,ttl);
    }



    public static JwtToken decodeJwtToken(String jwtToken) {
        JwtAdapter.TokenResult result = JwtAdapter.getJwtToken(jwtToken);
        JwtToken res = new JwtToken();
        //解密内容
        res.setData(result.getJwtObj());
        //jwtCode
        res.setJwtCode(result.getCode());
        //token密文
        res.setToken(jwtToken);
        res.setCanPass(result.isCanPass());
        return res;
    }



}
