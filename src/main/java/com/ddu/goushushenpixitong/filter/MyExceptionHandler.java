package com.ddu.goushushenpixitong.filter;

import com.ddu.goushushenpixitong.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther ChunKit
 * @date 2019/10/27-16:35
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public CommonResult ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return CommonResult.failure().setCode(403).setMessage("没有通过权限验证！");
    }

}