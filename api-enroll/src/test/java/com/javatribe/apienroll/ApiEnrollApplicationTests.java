package com.javatribe.apienroll;

import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.service.admin.EnrollNoticeAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.stream.IntStream;

@SpringBootTest
class ApiEnrollApplicationTests {
    @Resource
    EnrollNoticeAdminService service;
    @Test
    void contextLoads() {
        IntStream.range(0,10).forEach(x -> {
            EnrollNotice notice = new EnrollNotice();
            notice.setContent("http://wqqqqwqwq.images"+ x);
            notice.setTitle("我是标题" + x);
            show(service.add(notice));
        });


    }
    private void show(Object r) {
        System.out.println(r);
    }
}
