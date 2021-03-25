package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.WebTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author lyr
 * @create 2021/3/23 13:11
 */
@SpringBootTest(classes = WebTest.class)
class CompetitionIntroductionMapperCustomTest {
    @Autowired
    private CompetitionIntroductionMapperCustom dao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateSelective() {
    }

    @Test
    void selectFirstPageShow() {
    }

    @Test
    void getDetailInfoById() {
        this.dao.getDetailInfoById(1);
    }

    @Test
    void listAllCompetitionAndYears() {
        System.out.println(dao.listAllCompetitionAndYears());
    }
}