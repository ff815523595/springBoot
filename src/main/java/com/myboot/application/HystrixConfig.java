package com.myboot.application;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by a on 2017/10/10.
 */
@Configuration
public class HystrixConfig {
    @Bean
    public HystrixMetricsStreamServlet hystrixMetricsStreamServlet(){
         return new HystrixMetricsStreamServlet();
    }

    @Bean
    public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(servlet);
        registrationBean.setEnabled(true);//是否启用该registrationBean
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }
}
