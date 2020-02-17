package com.ddu.goushushenpixitong.auth.Controller;

import com.ddu.goushushenpixitong.auth.util.ShiroUtils;
import com.ddu.goushushenpixitong.util.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆验证
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public CommonResult login(@RequestParam("id") String id,
                              @RequestParam("password") String password) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(id, password);
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);

            Session session = subject.getSession();
//            String user_id = (String) subject.getPrincipal();
            //设置一小时登陆过期时间
            session.setTimeout(1800000);

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return CommonResult.failure("账号或密码错误");
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return CommonResult.failure("没有权限");
        }
        Map<String,String> map = new HashMap<>();
        map.put("token", ShiroUtils.getSession().getId().toString());
        return CommonResult.success().setData(map).setMessage("登陆成功");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public CommonResult unauth() {
        return CommonResult.failure().setCode(401).setMessage("未登录");
    }

}
