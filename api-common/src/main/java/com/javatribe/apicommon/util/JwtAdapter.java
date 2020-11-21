package com.javatribe.apicommon.util;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;

import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

/**
 * 代码太烂了，准备重写一份
 * @deprecated 添加了 JwtUtil 代替这个代码
 * @Author lyr
 * @create 2020/9/17 11:17
 */
@Slf4j
@Deprecated
public class JwtAdapter {
    public enum JWTCode {
        SUCCESS,ERROR,OVERDUE;
    }
    public static final String UNION_ID = "unionId";
    public static final String OPEN_ID = "openId";
    public static final String ID ="id";

    /*
     * 密文，用于加密解密Signature
     */
    private static final String JWT_SECRET = "org.javatribe";

    /**
     * 创建jwt
     *
     * @param id        用户的id
     * @param ttlMillis 过期的时间长度
     * @return token串
     * @throws Exception
     */
    public static String createJWT(String id, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();// 签发jwt的时间
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder().setIssuedAt(new Date())// 签发时间
                .claim("id", id)// 用户id
                .signWith(signatureAlgorithm, key).setExpiration(new Date(nowMillis + ttlMillis));

//		System.out.println(nowMillis );
//		System.out.println( ttlMillis);
        return builder.compact();
    }

    /**
     * 返回 jwt 给前端
     * @param tokenInfo
     * @param ttlMillis
     * @return
     */
    public static String createJWT(Map<String,?> tokenInfo, long ttlMillis){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();// 签发jwt的时间
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder().setIssuedAt(new Date());// 签发时间
        tokenInfo.forEach((k,v)->{
            builder.claim(k,v.toString());
        });
        builder.signWith(signatureAlgorithm, key).setExpiration(new Date(nowMillis + ttlMillis));
        return builder.compact();
    }



    /**
     * 生成加密秘钥
     *
     * @return 秘钥
     */
    private static SecretKey generalKey() {
        String stringKey =  JWT_SECRET;// 秘钥
        byte[] encodedKey = Base64.decode( stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 验证token
     *
     * @param jwt token串
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws RuntimeException {
        SecretKey key = generalKey();
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 验证token并返回信息
     * @param token
     * @return
     */
    public static JWTCode judgeToken(String token){
        try{
            parseJWT(token);
        }
        catch (ExpiredJwtException e) {

            log.info("token过期！",e);
            return JWTCode.OVERDUE;
        } catch (Exception e) {

            log.info("token无效！",e);
            return JWTCode.ERROR;
        }
        return JWTCode.SUCCESS;
    }
    public static String wechatToken(String id,String unionId,String openId,Duration duration) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();// 签发jwt的时间
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder().setIssuedAt(new Date())// 签发时间
                .claim(ID, id)// 用户id
                .claim(UNION_ID,unionId)
                .claim(OPEN_ID,openId)
                .signWith(signatureAlgorithm, key).setExpiration(new Date(nowMillis + duration.toMillis()));

        return builder.compact();
    }

    @Deprecated
    public static String getOpenId(HttpServletRequest request){
        String token = request.getHeader("token");
        String openId = "";
        try {
            openId = parseJWT(token).get("openId").toString();
        }
        catch (Exception e){
            System.out.println("tokn解析openId失败");
            log.error("tokn解析openId失败！",e);
            return null;
        }
        return openId;
    }


    public static void main(String[] args) {
        System.out.println(wechatToken("ssafasfas", IdUtil.simpleUUID(), IdUtil.simpleUUID(), Duration.ofDays(6)));
//         try {
//
//             String token =  createJWT("asdfafas",TimeUnit.HOURS.toMillis(10));
//             Cookie cookie = StringUtil.setCookie("mwentoken",token, (int)TimeUnit.HOURS.toMillis(10)) ;
//             String value =StringUtil.getCookie("mwentoken",new Cookie[]{cookie});
//             System.out.println(value);
//             System.out.println(token);
//             System.out.println(  parseJWT(value).get("openId").toString());
// //			 System.out.println(JWTUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NDQwODQ2NDUsInVOYW1lIjoiaGFuaGFvIiwidUlkIjoiOSIsImV4cCI6MTU0NTg4NDY0NX0.NrqMOWG0AadZUX1ZHkQukZakRz-SgOLqrKjytBEb33c").get("uName").toString());
//         } catch (ExpiredJwtException e) {
//             System.out.println("token过期");
//         } catch (Exception e) {
//             System.out.println("token无效!!!");
//             e.printStackTrace();
//         }
    }
    @Data
    public static class TokenResult {
        private boolean canPass;
        private JWTCode code;
        private Claims jwtObj;
    }


    /**
     * 获取 token信息
     * @param token token
     * @return token的信息
     */
    public static TokenResult getJwtToken(String token) {
        // String token = request.getHeader("token");

        TokenResult tokenResult = new TokenResult();
        try{
            Claims claims = parseJWT(token);
            tokenResult.setCanPass(true);
            tokenResult.setCode(JWTCode.SUCCESS);
            tokenResult.setJwtObj(claims);
        } catch (ExpiredJwtException e) {
            //过期
            // tokenResult.setCanPass(false);
            tokenResult.setCode(JWTCode.OVERDUE);


        } catch (Exception e) {
            tokenResult.setCode(JWTCode.ERROR);
            // tokenResult.setCanPass(false);
            //默认为 false，不用设置


        }

        return tokenResult;
    }

}


