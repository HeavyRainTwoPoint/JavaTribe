package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.WebTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author lyr
 * @create 2021/3/23 14:07
 */
@SpringBootTest(classes = WebTest.class)
class StyleShowMapperCustomTest {
    @Autowired
    private StyleShowMapperCustom styleShowMapperCustom;

    @Test
    void getFirstPage() {
    }

    @Test
    void getByCompetitionIdAndYearId() {
        //styleShowMapperCustom.getByCompetitionIdAndYearId(3,"4");
    }
}