package com.ddu.goushushenpixitong.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 用于获取当前登陆人员的信息
 * @auther ChunKitAu
 * @create 2019-12-10 10
 */
public class LoginStaffUtil {
    /**
     *  返回当前登陆的人员的工号
     * @return
     */
    public static String getLogInStaffId(){
        Subject subject = SecurityUtils.getSubject();
        return subject.getPrincipal().toString();
    }


}
