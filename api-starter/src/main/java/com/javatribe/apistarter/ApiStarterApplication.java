package com.javatribe.apistarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.javatribe")
// <<<<<<< HEAD
// @MapperScan({"com.javatribe.apishare.mapper","com.javatribe.apicompetition.mapper"})

// @MapperScan()
// =======
@MapperScan({"com.javatribe.apishare.mapper", "com.javatribe.introduction.mapper","com.javatribe.apilife.dao"})
// >>>>>>> 9d8a4a18581b6f94fa77c62de6634b3d29b70eea
public class ApiStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiStarterApplication.class, args);
    }


}
