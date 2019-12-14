package com.ddu.goushushenpixitong.shiro;

import com.ddu.goushushenpixitong.entity.Role;
import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.enums.RoleType;
import com.ddu.goushushenpixitong.service.RoleService;
import com.ddu.goushushenpixitong.service.StaffService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {


    @Autowired
    private StaffService staffService;

    @Autowired
    private RoleService roleService;

    /**
     * 提供用户信息返回权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登陆账号
        String staffId = (String) principalCollection.getPrimaryPrincipal();

        //根据学号查询人员信息
        Staff staff = staffService.findById(staffId);

        Set<String> roles = new HashSet<>();
        //根据工号号获取角色
        List<Role> roles1 = roleService.findById(staffId);

        for (Role r :
                roles1) {
            RoleType roleType = RoleType.typeOf(r.getType());
            roles.add(roleType.getTypeInfo());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRoles(roles);

        return simpleAuthorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        if (authenticationToken.getPrincipal() == null) {
            return null;
        }

        String staffId = authenticationToken.getPrincipal().toString();
        //获取员工信息
        Staff staff = staffService.findById(staffId);

        if (staff == null) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException();
        }


        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(staffId, staff.getPwd().toString(), getName());
        return simpleAuthenticationInfo;

    }


}
