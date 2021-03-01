package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.javatribe.apienroll.entity.TestNoticeQTO;
import com.javatribe.apienroll.service.EnrollDirectionService;
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
    @Test
    public void testQueryDirection() {
       show(enrollDirectionService.getLastNItemsOnPerDirection(3));
    }


    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r.toString().replace("Response","")));
    }

}
