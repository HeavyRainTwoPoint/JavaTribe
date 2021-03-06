package com.javatribe.apistarter;

import com.javatribe.apicompetition.mapper.StyleShowMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApiStarterApplicationTests {

    @Resource
    private StyleShowMapper styleShowMapper;
    @Test
    void contextLoads() {
        Assertions.assertNotNull(styleShowMapper);
    }




}
