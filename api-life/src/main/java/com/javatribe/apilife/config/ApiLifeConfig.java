package com.javatribe.apilife.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.javatribe.apilife.dao")
public class ApiLifeConfig {

}
