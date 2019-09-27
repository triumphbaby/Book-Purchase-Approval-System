package com.ddu.goushushenpixitong.controller;

import com.ddu.goushushenpixitong.util.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public CommonResult test() {
        return CommonResult.success().setData("mdzz");
    }

}
