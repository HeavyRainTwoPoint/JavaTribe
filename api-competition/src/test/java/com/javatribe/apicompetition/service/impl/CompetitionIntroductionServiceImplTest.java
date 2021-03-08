package com.javatribe.apicompetition.service.impl;

import com.aliyun.oss.OSS;
import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
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

    @Resource
    OSS oss;
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
    CompetitionIntroduction mock() {
        return new CompetitionIntroduction()
                .withDeleteStatus(false)
                .withSignUp(0)
                .withCompetitionName("蓝桥杯")
                .withShowContent("蓝桥杯啦啦   <script>alert()</script>");
    }
    @Test
    // @Transactional(propagation = Propagation.NEVER)
    void insertCompetitionInfo() throws Exception {
        competitionIntroductionService.insertCompetitionInfo(mock());
        // throw new Exception("测试");
    }

    @Test
    void deleteCompetitionInfoById() {
        System.out.println(oss);
    }

    @Test
    void updateCompetitionInfo() {
    }
}