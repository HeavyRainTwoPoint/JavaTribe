package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSS;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.service.admin.EnrollNoticeAdminService;
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
public class EnrollNoticeTest {
    @Resource
    OSS oss;
    @Resource
    EnrollNoticeAdminService service;
    @Test
    public void testAdd() {
        IntStream.range(0,10).forEach(x -> {
            EnrollNotice notice = new EnrollNotice();
            notice.setContent("http://wqqqqwqwq.images"+ x);
            notice.setTitle("我是标题" + x);
            show(service.add(notice));
        });
    }


    @Test
    public void testDel() {
        LongStream.range(20,30).forEach(x -> {
            EnrollNotice notice = new EnrollNotice();
            notice.setId(null);
            show(service.deleteById(notice));
        });
    }

    @Test
    public void testDelByQTO() {
        EnrollNoticeQTO qto = new EnrollNoticeQTO();
        qto.createCriteria().andIdIn(Arrays.asList(31L,32L,33L,34L,35L,36L));
        show(service.delete(qto));
    }



    @Test
    public void testQuery() {
            EnrollNoticeQTO qto = new EnrollNoticeQTO();
            qto.setOrderByClause("gmt_created desc");
            show(service.query(qto));
    }


    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r.toString().replace("Response","")));
    }
}
