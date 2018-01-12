package com.myboot.controller;

import com.myboot.bean.User;
import com.myboot.service.IUserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by a on 2017/10/10.
 */
@RestController
@EnableAutoConfiguration
public class HelloWorld {

    private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String hello() {

        return "hello,Spring boot! and driverClass=";
    }

    @RequestMapping("/word/{name}")
    public String word(@PathVariable String name) {
        return "word--spring boot:" + name;
    }

    @RequestMapping("/user/{name}")
    public String findUser(@PathVariable String name){
        logger.info("查询用户名："+name);
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录error错误日志");
        User user = userService.findUserByName(name);
        System.out.println(user.getName());
        return "find user name:"+user.getName()+" ,age:"+user.getAge();
    }
}
