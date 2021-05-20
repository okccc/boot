package com.okccc.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: okccc
 * Date: 2021/5/17 下午5:55
 * Desc: 控制层代码
 */
@Slf4j  // lombok可以简化日志开发
@RestController
public class ControllerDemo {

    @RequestMapping("/hello")
    public String handler01() {
        log.info("请求进来了...");
        return "hello spring boot2!";
    }
}
