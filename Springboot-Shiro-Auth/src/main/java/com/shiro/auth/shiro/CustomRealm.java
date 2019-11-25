package com.shiro.auth.shiro;

import com.shiro.auth.pojo.Permissions;
import com.shiro.auth.pojo.User;
import com.shiro.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName CustomRealm
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-19 11:03
 * @Version 1.0
 **/
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 用户授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始用户授权-----------------------------------");
        String name = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.login(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //赋予角色名称
        simpleAuthorizationInfo.addRole(user.getRoleName());
        //赋予角色权限
        for (Permissions ps : user.getPermissions()
                ) {
            simpleAuthorizationInfo.addStringPermission(ps.getPermissionsName());
        }
        log.info("结束用户授权-----------------------------------");
        return simpleAuthorizationInfo;

    }

    /**
     * 用户验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("开始身份验证-----------------------------");
        if (null == authenticationToken.getPrincipal()) {
            throw new IncorrectCredentialsException("token失效了");
        }
        String name = (String) authenticationToken.getPrincipal();
        User user = userService.login(name);
        if (null == user) {
            throw new UnknownAccountException("用户不存在");
        } else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
            log.info("结束身份验证-----------------------------");
            return simpleAuthenticationInfo;
        }
    }
}
