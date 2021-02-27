package com.javatribe.direction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mybatis 通用mapper所在的包
@MapperScan(basePackages = "com.javatribe.direction.mapper")
public class ApiDirectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDirectionApplication.class, args);
    }

}
