package com.javatribe.apilife.config;

import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.service.PriorityService;
import com.javatribe.apilife.service.impl.PriorityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ApiLifeConfig {
    @Bean
    public PriorityService<Activity> priorityService(){
        return new PriorityServiceImpl<>(
                new ArrayList<Activity>(){
                    {
                        add(new Activity(123, "部落环境", 1));
                        add(new Activity(125, "部落福利", 3));
                        add(new Activity(126, "部落很好", 4));
                        add(new Activity(124, "部落聚餐", 2));
                    }
                },
                Activity.class,
                "id",
                "priority"
        );

    }
}
