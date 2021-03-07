package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.EnrollDirectionService;
import com.javatribe.apienroll.service.EnrollNoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:17
 * @description
 */
@SpringBootTest(classes = ApiEnrollApplication.class)
public class OpenServiceTest {
    @Resource
    private EnrollDirectionService enrollDirectionService;

    @Resource
    private EnrollNoticeService enrollNoticeService;
    @Test
    public void testQueryDirection() {
       show(enrollDirectionService.getLastNItemsOnPerDirection(3));
    }

    @Test
    public void getEnrollNoticeAndDocxUrlOnDirection() {
        show(enrollNoticeService.getEnrollNoticeAndDocxUrlOnDirection(1));
    }


//    private void show(Object r) {
//        System.out.println(JSONUtil.toJsonStr(r.toString().replace("Response","")));
//    }
    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r));
    }

}
