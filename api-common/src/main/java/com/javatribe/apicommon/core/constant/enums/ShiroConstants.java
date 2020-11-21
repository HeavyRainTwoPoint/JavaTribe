package com.javatribe.apicommon.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Iterator;

/**
 * 对于 shiro常量的封装
 * @Author lyr
 * @create 2020/10/25 0:23
 */
@Getter
@AllArgsConstructor
public enum ShiroConstants {
    /*
    * 匿名访问
    * */
    Anon("anon")
    ,
    /**
     * 登录后可以访问
     *
     */
    Authc("authc"),
    /**
     * 指定角色访问
     */
    Roles("roles"),
    /**
     * 指定角色权限访问
     * permission
     *
     */
    Perms("perms")

    ,

    /**
     * 必须拥有记住我的功能才能用
     */
    User("user")
    ;

    String content;



    public static String buildPermissionExpression(Iterable<String> permissionExpressionList) {
        StringBuilder sb = new StringBuilder("perms[");
        Iterator it = permissionExpressionList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }



    @Override
    public String toString() {
        return content;
    }
}
