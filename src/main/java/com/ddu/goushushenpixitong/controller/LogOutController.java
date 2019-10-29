package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 退出登陆
 * @auther ChunKit
 * @date 2019/10/27-16:31
 */
@RestController
public class LogOutController {

    @RequestMapping(value = "/logout")
    public CommonResult logout() {
        Subject lvSubject= SecurityUtils.getSubject();
        lvSubject.logout();
        return CommonResult.success().setMessage("退出成功");
    }
}
