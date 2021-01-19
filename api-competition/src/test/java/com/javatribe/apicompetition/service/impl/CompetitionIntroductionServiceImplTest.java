package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author lyr
 * @create 2021/1/17 1:36
 */
@SpringBootTest(classes = WebTest.class)
class CompetitionIntroductionServiceImplTest {
    @Resource
    CompetitionIntroductionService competitionIntroductionService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    // @Transactional
    void firstPageShow() {
        System.out.println(competitionIntroductionService.firstPageShow());
        System.out.println(competitionIntroductionService.firstPageShow());
    }

    @Test
    void insertCompetitionInfo() {
        competitionIntroductionService.insertCompetitionInfo(new CompetitionIntroduction());
    }

    @Test
    void deleteCompetitionInfoById() {
    }

    @Test
    void updateCompetitionInfo() {
    }
}