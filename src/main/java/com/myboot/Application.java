package com.myboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by a on 2017/10/10.
 */
@SpringBootApplication
@ComponentScan("com.myboot")
@MapperScan(basePackages = "com.myboot.mapper")
/*@ImportResource(locations={"classpath:application-bean.xml"}) 可导入指定的xml文件*/
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
