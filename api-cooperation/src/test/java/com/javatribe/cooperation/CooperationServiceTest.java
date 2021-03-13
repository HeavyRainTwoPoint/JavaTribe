package com.javatribe.cooperation;

import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.mapper.CooperationMapper;
import com.javatribe.cooperation.service.CooperationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author LCW
 * @since 2021/3/11 13:25
 **/
@SpringBootTest
public class CooperationServiceTest {

    @Resource
    CooperationService cooperationService;

    @Resource
    CooperationMapper cooperationMapper;
    Random random = new Random();
    @Test
    public void testInsert() {
        int flag = 0;
        for (int i = 0; i < 100; i++) {
            Cooperation cooperation = new Cooperation();

            cooperation.setUpdateBy(random.nextInt(1000000000));
            cooperation.setCreateBy(random.nextInt(1000000000));
            cooperation.setContent(random.nextInt(1000000000) + "");
            if (flag == 0) {
                cooperation.setType(0);
                flag = 1;
            } else {
                cooperation.setType(1);
                flag = 0;
            }
            cooperation.setTitle("张三" + random.nextInt(10000) + "xxxx");
            cooperation.setPhoto("http://img.1ppt.com/uploads/allimg/2103/1-210312131R80-L.jpg");
            cooperationService.insert(cooperation);

        }

    }

    @Test
    public void testGet() {
        Cooperation cooperation = cooperationMapper.selectById(12);
        System.out.println(cooperation);

    }

    @Test
    public void testUpdate() {
        List<Cooperation> page = cooperationService.page(0, 0, 1000);
        for (Cooperation cooperation : page) {
            cooperation.setItems("张三" + random.nextInt(10000)
                    + " "+"李四" + random.nextInt(10000)
                    + " "+"王五" + random.nextInt(10000)
            );
            cooperationService.update(cooperation);
        }

    }

    @Test
    public void testDelete() {
      cooperationService.delete(1);
    }

    @Test
    public void testGetAll() {
        System.out.println(cooperationService.getAll(1));
        System.err.println(cooperationService.getAll(0));
    }

    @Test
    public void testPage() {
        System.out.println(cooperationService.page(0, 0,10));
    }

    @Test
    public void getCounts() {
        System.out.println(cooperationService.getCounts(0));
        System.out.println(cooperationService.getCounts(1));
    }

    @Test
    public void getAllCounts() {
        System.out.println(cooperationService.getAllCounts());
    }


}
