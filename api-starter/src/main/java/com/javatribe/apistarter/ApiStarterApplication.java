package com.javatribe.apistarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.javatribe")
public class ApiStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApplication.class, args);
    }

}
