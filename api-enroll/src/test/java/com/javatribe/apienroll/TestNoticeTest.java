package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSS;
import com.javatribe.apienroll.entity.FileManagerQTO;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.admin.TestNoticeAdminService;
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
public class TestNoticeTest {
    @Resource
    OSS oss;
    @Resource
    TestNoticeAdminService service;
    @Test
    public void testAdd() {
        IntStream.range(1,5).forEach(x -> {
            TestNotice notice = new TestNotice();
            notice.setTestName("前端考核第"+x+"次");
            notice.setNoticeFile("['http://www.baidu.com','http://www.baidu2.com','http://www.baidu3.com','http://www.baidus.com']");
            notice.setTestDirection(1);
            show(service.add(notice));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    @Test
    public void testDel() {
        LongStream.range(5,14).forEach(x -> {
            TestNotice notice = new TestNotice();
            notice.setId(x);
            show(service.deleteById(notice));
        });
    }

    @Test
    public void testDelByQTO() {
        TestNoticeQTO qto = new TestNoticeQTO();
        qto.createCriteria().andIdIn(Arrays.asList(31L,32L,33L,34L,35L,36L));
        show(service.delete(qto));
    }

    @Test
    public void testQuery() {
            TestNoticeQTO qto = new TestNoticeQTO();
            qto.setOrderByClause("gmt_created desc");
            show(service.query(qto));
    }





    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r));
    }

}
