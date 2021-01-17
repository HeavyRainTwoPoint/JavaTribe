package com.javatribe.apistarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.javatribe")
@MapperScan("com.javatribe.apishare.mapper")
public class ApiStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApplication.class, args);
    }

}
