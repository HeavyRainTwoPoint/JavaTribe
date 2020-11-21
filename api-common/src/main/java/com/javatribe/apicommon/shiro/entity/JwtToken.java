package com.javatribe.apicommon.shiro.entity;

import com.javatribe.apicommon.util.JwtAdapter;
import io.jsonwebtoken.Claims;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author lyr
 * @create 2020/10/25 9:48
 */
@Data
public class JwtToken implements AuthenticationToken {

    /**
     * token 内容
     */
    private String token;
    /**
     * jwt校验结果
     */
    private JwtAdapter.JWTCode jwtCode;
    /**
     * 解密结果
     */
    private Claims data;

    /**
     * 是否可以通过
     */
    private boolean canPass;

    @Override
    public Object getPrincipal() {
        return this;
    }

    @Override
    public Object getCredentials() {
        return this;
    }

    /**
     * @return token 过期
     */
    public boolean isExpire() {
        return JwtAdapter.JWTCode.OVERDUE.equals(jwtCode);
    }

    /**
     * @return 校验失败
     */
    public boolean isCheckFail() {
        return JwtAdapter.JWTCode.ERROR.equals(jwtCode);
    }

    /**
     * @return 校验成功
     */
    public boolean isSuccess() {
        return JwtAdapter.JWTCode.SUCCESS.equals(jwtCode);
    }
}
