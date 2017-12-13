package com.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by a on 2017/10/10.
 */
@SpringBootApplication
@ComponentScan("com.myboot")
@MapperScan(basePackages = "com.myboot.mapper")
@ServletComponentScan(basePackages = "com.myboot.servlet")
@EnableTransactionManagement
/*@ImportResource(locations={"classpath:application-bean.xml"}) 可导入指定的xml文件*/
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
