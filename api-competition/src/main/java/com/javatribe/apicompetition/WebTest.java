package com.javatribe.apicompetition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lyr
 * @create 2021/1/13 22:24
 */
@MapperScan("com.javatribe.apicompetition.mapper")
@SpringBootApplication(scanBasePackages = "com.javatribe")
public class WebTest {


    public static void main(String[] args) {
        SpringApplication.run(WebTest.class, args);
    }

}
