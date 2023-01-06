package com.it.oa.config.shiro;

import com.it.oa.entity.UserEntity;
import com.it.oa.service.RolePermissionService;
import com.it.oa.service.UserRoleService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(MyRealm.class);

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RolePermissionService rolePermissionService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 权限处理
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.warn("权限 授权 doGetAuthorizationInfo");
        Integer userId = JwtUtil.getUserId(principals.toString());

        // 查询用户角色
        List<String> roles = userRoleService.getRoles(userId);

        // 设置用户角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);

        List<String> permissionCodes = rolePermissionService.getPermissionByRoles(roles);
        authorizationInfo.addStringPermissions(permissionCodes);
        return authorizationInfo;
    }

    /**
     * 认证处理
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        log.warn("权限 认证处理 doGetAuthenticationInfo");
        String token = (String) auth.getCredentials();
        // 解密获得userName，用于和数据库进行对比
        String userName = JwtUtil.getUserName(token);
        UserEntity vo = userService.getUserByName(userName);
        // return new SimpleAuthenticationInfo(vo, vo.getPassword(), token);
        return new SimpleAuthenticationInfo(token, token, vo.getUserName());
    }
}
