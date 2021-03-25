package com.javatribe.apicompetition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author lyr
 * @create 2021/1/13 22:24
 */
@MapperScan(basePackages = {"com.javatribe.apicompetition.mapper","com.javatribe.apicommon.dao"})
@SpringBootApplication(scanBasePackages = "com.javatribe")
@EnableAspectJAutoProxy(exposeProxy = true)
public class WebTest {


    public static void main(String[] args) {
        SpringApplication.run(WebTest.class, args);
    }

}
