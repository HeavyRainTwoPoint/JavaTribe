package com.javatribe.apilife.config;

import com.javatribe.apilife.dao.ActivityDao;
import com.javatribe.apilife.dao.TagDao;
import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.pojo.Tag;
import com.javatribe.apilife.service.PriorityService;
import com.javatribe.apilife.service.impl.PriorityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ApiLifeConfig {
    @Bean@Autowired
    public PriorityService<Tag> priorityService(TagDao tagDao){
        return new PriorityServiceImpl<>(
                tagDao.selectAll(),
                Tag.class,
                "id",
                "priority",
                "parent"
        );

    }
}
