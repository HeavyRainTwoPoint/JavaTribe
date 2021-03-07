package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import com.javatribe.apienroll.service.admin.EnrollTestAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 16:32
 * @description
 */
@SpringBootTest(classes = ApiEnrollApplication.class)
public class EnrollTestTest {

    @Resource
    EnrollTestAdminService service;

    @Test
    public void testAdd() {
//        IntStream.range(1,5).forEach(x -> {
//            EnrollTest test = new EnrollTest();
//            test.setFileUrl("http://javatribe/file/11233");
//            test.setTestName("梁永辉前端第"+x+"次考核");
//            test.setOwnnerName("梁永辉");
//            show(service.add(test));
//        });

        IntStream.range(1, 5).forEach(x -> {
            EnrollTest test = new EnrollTest();
            test.setFileUrl("http://javatribe/file/11233");
            test.setTestName("梁永辉设计第" + x + "次考核");
            test.setOwnnerName("梁永辉");
            test.setDirectionCode(3);
            show(service.add(test));
        });
    }


    @Test
    public void testDel() {
        LongStream.range(13, 16).forEach(x -> {
            EnrollTest test = new EnrollTest();
            test.setId(x);
            show(service.deleteById(test));
        });
    }

    @Test
    public void testDelByQTO() {
        EnrollTestQTO qto = new EnrollTestQTO();
        qto.createCriteria().andDirectionCodeIn(Arrays.asList(1,2));
        show(service.delete(qto));
    }

    @Test
    public void testQuery() {
        EnrollTestQTO qto = new EnrollTestQTO();
        qto.createCriteria().andDirectionCodeIn(Arrays.asList(1,2,3));
        qto.setOrderByClause("gmt_created desc");
        show(service.query(qto));
    }


    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r.toString().replace("Response","")));
    }

}
