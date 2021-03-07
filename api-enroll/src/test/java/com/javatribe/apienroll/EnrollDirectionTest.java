package com.javatribe.apienroll;

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSS;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.service.admin.EnrollDirectionAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 16:32
 * @description
 */
@SpringBootTest(classes = ApiEnrollApplication.class)
public class EnrollDirectionTest {
    @Resource
    OSS oss;
    @Resource
    EnrollDirectionAdminService service;
    @Test
    public void testAdd() {
//        IntStream.range(1,8).forEach(x -> {
//            EnrollDirection direction = new EnrollDirection();
//            direction.setDirectionCode(1);
//            direction.setDirectionName("方向名称" + );
//        });

        EnrollDirection direction = new EnrollDirection();
        direction.setDirectionCode(1);
        direction.setDirectionName("前端");
        show(service.add(direction));

        EnrollDirection direction2 = new EnrollDirection();
        direction.setDirectionCode(2);
        direction.setDirectionName("后端");
        show(service.add(direction));


        EnrollDirection direction3 = new EnrollDirection();
        direction.setDirectionCode(3);
        direction.setDirectionName("设计");
        show(service.add(direction));


        EnrollDirection direction4 = new EnrollDirection();
        direction.setDirectionCode(4);
        direction.setDirectionName("算法");
        show(service.add(direction));


        EnrollDirection direction5 = new EnrollDirection();
        direction.setDirectionCode(5);
        direction.setDirectionName("产品");
        show(service.add(direction));


        EnrollDirection direction6 = new EnrollDirection();
        direction.setDirectionCode(6);
        direction.setDirectionName("安卓");
        show(service.add(direction));


    }



    @Test
    public void testQuery() {
            EnrollDirectionQTO qto = new EnrollDirectionQTO();
            qto.setOrderByClause("gmt_created desc");
            show(service.query(qto));
    }


    private void show(Object r) {
        System.out.println(JSONUtil.toJsonStr(r));
    }

}
