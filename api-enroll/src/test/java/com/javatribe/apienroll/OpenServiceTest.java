package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.javatribe.apienroll.service.openapi.EnrollOpenApiService;
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
    private EnrollOpenApiService enrollOpenApiService;
    @Test
    public void testQueryDirection() {
       show(enrollOpenApiService.getLastNTestNameOnPerDirection(4));
    }



    @Test
    public void testEnrollNotice() {
        show(enrollOpenApiService.getEnrollNoticeGroupByYear(2));
    }

    @Test
    public void getTestNoticeOnDirection() {
        show(enrollOpenApiService.getTestNoticeOnDirection(2));
    }

    @Test
    public void getLastNTestNameOnPerDirection() {
        show(enrollOpenApiService.getLastNTestNameOnPerDirection(4));
    }
//    private void show(Object r) {
//        System.out.println(JSONUtil.toJsonStr(r.toString().replace("Response","")));
//    }
    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r));
    }

}
