
import com.javatribe.apicompetition.WebTest;
import com.javatribe.apicompetition.mapper.StyleShowMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @Author lyr
 * @create 2021/1/13 22:19
 */

@SpringBootTest(classes = WebTest.class)
public class AAATEST {

    @Resource
    private StyleShowMapper styleShowMapper;

    @Test
    public void ss() {
        System.out.println(styleShowMapper);
        Assertions.assertNotNull(styleShowMapper);
        // System.out.println("hhh");
    }




}
