package com.myboot.hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.HystrixCommand.Setter;

/**
 * Created by a on 2017/10/10.
 */
public class HystrixUtil {

    private final int TIME_OUT_SECOND = 3000;

    public String execute(String hotelServiceName , String hotelServiceMethodGetHotelInfo, String url ){
        //通过定义 Setter 的缓存，可以避免每次构造新的命令时重新构造 Setter
        Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(hotelServiceName));//被调用服务
        setter.andCommandKey(HystrixCommandKey.Factory.asKey(hotelServiceMethodGetHotelInfo));//被调用服务的一个被调用方法
        setter.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(TIME_OUT_SECOND));//超时时间设置
        setter.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withMaxQueueSize(10)//配置队列大小
                .withCoreSize(10)// 配置线程池里的线程数
        );//配置队列大小
       /* setter .andCommandPropertiesDefaults(    // 配置信号量隔离
                HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)    // 信号量隔离
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(2)
        );*/
        return new MyHystrixCommand(setter, url).execute();//同步执行
    }
}
