package com.javatribe.apicompetition.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lyr
 * @create 2021/1/13 22:31
 */

@Configuration
@EnableCaching
@MapperScan("com.javatribe.apicompetition.mapper")
public class CompetitionModuleConfig {

}
