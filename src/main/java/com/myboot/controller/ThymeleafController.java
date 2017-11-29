package com.myboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by a on 2017/11/29.
 */
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {

    private static final Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @RequestMapping(value="/greeting")
    public String greeting(@RequestParam(name = "name",required = false,defaultValue = "jack") String name , ModelMap model){
        logger.info("开始执行thymeleaf方法，获取参数name="+name);

        model.put("xname" , name);
        return "index";
    }
}
