package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author lyr
 * @create 2021/2/1 0:08
 */
@SpringBootTest(classes = WebTest.class)
class TribeStyleShowServiceImplTest {
    @Resource
    TribeStyleShowService tribeStyleShowService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllStyleShow() {
        System.out.println(tribeStyleShowService.getAllStyleShow());
    }

    @Test
    void updateById() {
    }
    StyleShow mock() {
        return new StyleShow()
                .withTeamName("哈哈队伍")
                .withProjectName("搜索引擎 <script>alert('ssss')</script>")
                .withShowOrder(2)
                .withCompetitionId(3L)
                .withTeamBeginTime(new Date())
                .withTeamEndTime(new Date());
    }

    @Test
    void insertOne() {
         tribeStyleShowService.insertOne(mock());
    }

    @Test
    void deleteById() {
    }
}