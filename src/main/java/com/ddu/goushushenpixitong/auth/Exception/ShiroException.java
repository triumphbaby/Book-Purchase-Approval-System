package com.ddu.goushushenpixitong.auth.Exception;

import com.ddu.goushushenpixitong.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther ChunKitAu
 * @create 2020-01-15 15
 */
@ControllerAdvice
@Slf4j
public class ShiroException {

    /**
     * 处理Shiro权限拦截异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler
    public CommonResult ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return CommonResult.failure().setCode(403).setMessage("没有通过权限验证！");
    }

}
