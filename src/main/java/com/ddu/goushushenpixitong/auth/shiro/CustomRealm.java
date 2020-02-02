package com.ddu.goushushenpixitong.auth.shiro;

import com.ddu.goushushenpixitong.auth.Service.AuthService;
import com.ddu.goushushenpixitong.auth.dao.AuthDAO;
import com.ddu.goushushenpixitong.auth.util.ShiroUtils;
import com.ddu.goushushenpixitong.entity.Staff;
import com.ddu.goushushenpixitong.mapper.StaffMapper;
import com.ddu.goushushenpixitong.service.StaffService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther ChunKitAu
 * @create 2019-11-14 14
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    StaffService staffService;

    @Autowired
    AuthService authService;
    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Staff staff = (Staff) principalCollection.getPrimaryPrincipal();
        //获取用户id
        String staffId = staff.getId();

        Set<String> roleSet = new HashSet<>();
        Set<String> powerSet = new HashSet<>();

        List<AuthDAO> authDAOList = authService.getStaff_RoleAndPower(staffId);

        //添加角色和权限
        for (AuthDAO au:authDAOList) {
            roleSet.add(au.getRole());
            powerSet.add(au.getPower());
        }

        //将权限和角色传入到SimpleAuthorizationInfo 中
        simpleAuthorizationInfo.setStringPermissions(powerSet);
        simpleAuthorizationInfo.setRoles(roleSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 获取用户信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;

        if(authenticationToken.getPrincipal() == null) return null;

        //获取用户信息
        String staffId = authenticationToken.getPrincipal().toString();

        //获取员工信息
        Staff staff = staffService.findById(staffId);

        if(staff == null) throw new UnknownAccountException();

        //盐值.
        ByteSource salt = ByteSource.Util.bytes(staffId);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(staff, staff.getPwd(), salt, getName());

        //验证成功开始踢人(清除缓存和Session)
        ShiroUtils.deleteCache(staffId,true);
        return simpleAuthenticationInfo;
    }
}
