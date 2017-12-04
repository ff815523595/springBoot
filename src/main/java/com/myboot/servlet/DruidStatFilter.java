package com.myboot.servlet;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by a on 2017/11/29.
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",asyncSupported = true,
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*,/demo/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {
}
