
import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapper;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.mapper.StyleShowMapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @Author lyr
 * @create 2021/1/13 22:19
 */
@RequiredArgsConstructor
@SpringBootTest(classes = WebTest.class)
public class AAATEST {


    @Autowired
    StyleShowMapper styleShowMapper;
    @Autowired
    CompetitionIntroductionMapperCustom competitionIntroductionMapperCustom;
    @Autowired
    CompetitionIntroductionMapper competitionIntroductionMapper;

    @Test
    public void ss() {
        System.out.println(styleShowMapper);
        Assertions.assertNotNull(styleShowMapper);
        // System.out.println("hhh");
    }


    @Test
    void update_by_primary_key() {
        competitionIntroductionMapperCustom.updateSelective(new CompetitionIntroduction().withCompetitionName("软色").withCompetitionId(1L));
    }

    @Test
    void insert_introduction_info() {
        competitionIntroductionMapper.insert(new CompetitionIntroduction()
        .withCompetitionName("软色").withShowContent("hello world")
        );
    }






}
