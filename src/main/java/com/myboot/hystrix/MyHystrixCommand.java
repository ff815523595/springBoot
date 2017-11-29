package com.myboot.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by a on 2017/10/10.
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;

    public MyHystrixCommand(Setter setter ,String name) {
        super(setter);
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name + "!"+"线程名称是："+Thread.currentThread().getName();
    }

    @Override
    public String getFallback(){
        return "fall back";
    }
}
