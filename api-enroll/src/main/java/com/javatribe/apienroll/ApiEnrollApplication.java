package com.javatribe.apienroll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.javatribe")
@MapperScan("com.javatribe.apienroll.dao")
public class ApiEnrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEnrollApplication.class, args);
    }

}
