package com.javatribe.apicommon.shiro.realm;


import com.javatribe.apicommon.shiro.entity.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;


import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lyr
 * @create 2020/10/25 11:36
 */
@Slf4j

public class JwtRealm extends AuthorizingRealm {


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }


    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // if (!(authenticationToken instanceof JwtToken)) {
        //     return null;
        // }

        JwtToken token = ((JwtToken) authenticationToken);
        // System.out.println(token);
        // String id = token.getData().get("id").toString();
        return new SimpleAuthenticationInfo(token, token, getName());
        // if(token.isCanPass()) {
        //     log.info("验证通过");
        //     return new SimpleAuthenticationInfo(token,token,getName());

    }

    // @Resource
    // private PermissionMapperCustom permissionMapperCustom;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo per = new SimpleAuthorizationInfo();
        // SecurityUtils.getSubject() --> 获取当前用户，和 获取对应的 token的信息
        Subject subject = SecurityUtils.getSubject();

        // String id = subject.getPrincipal().toString();
        // log.info("用户id授权 {}",id);
        JwtToken jwtToken = (JwtToken) subject.getPrincipal();
        // String role = jwtToken.getData().get("role").toString();
        // if ("1".equals(role)) {
        //     //超级管理员
        //     per.addRole(Role.admin);
        // } else if ("2".equals(role)) {
        //     per.addRole(Role.teacher);
        // } else {
        //     //学生
        //     per.addRole(Role.student);
        // }
        // per.addStringPermissions();
        //进行授权操作
        // String sid = jwtToken.getData().get("id").toString();
        // log.info("sid {}", sid);
        // List<String> permisson = permissionMapperCustom.selectPermissionByUserId(Integer.valueOf(sid));
        // log.info("permissionList {}", permisson);
        // if (permisson.isEmpty() == false) {
        //     per.addStringPermissions(permisson);
        // }
        return per;
    }
}
