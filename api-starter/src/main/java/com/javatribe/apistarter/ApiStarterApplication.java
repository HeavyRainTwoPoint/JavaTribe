package com.javatribe.apistarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.javatribe")
public class ApiStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApplication.class, args);
    }

}
