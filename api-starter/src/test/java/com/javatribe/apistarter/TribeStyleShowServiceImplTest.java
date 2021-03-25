package com.javatribe.apistarter;

import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

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
    StyleShow mock(int i) {
        return new StyleShow()
                .withTeamName("哈哈队伍" +i)
                .withProjectName("搜索引擎" +i)
                .withImgs("https://javatribe.oss-cn-guangzhou.aliyuncs.com/article/202101201930411082.gif?versionId=CAEQBRiBgMDSnZ_.uBciIDgxZTU4OWViYzJjOTQ5Zjc4YjAwOWE5MjExNDY2ZGQ5")
                .withShowOrder(2)
                .withCompetitionId(1L)
                .withTeamBeginTime(new Date())
                .withTeamEndTime(new Date());
    }

    @Test
    @RepeatedTest(4)
    void insertOne() {
         for (int i=1;i<8;++i) {
             StyleShow x = mock(i);
             x.setCompetitionId((long) i);
             x.setTheYear(String.valueOf(i));
             tribeStyleShowService.insertOne(x);
         }
    }

    @Test
    void deleteById() {
    }
}