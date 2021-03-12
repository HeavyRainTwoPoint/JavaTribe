package com.javatribe.cooperation;

import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.mapper.CooperationMapper;
import com.javatribe.cooperation.service.CooperationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

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

    @Test
    public void testInsert() {
        Cooperation cooperation = new Cooperation();
        cooperation.setUpdateTime(new Date());
        cooperation.setCreateTime(new Date());
        cooperation.setUpdateBy(1);
        cooperation.setCreateBy(1);
        cooperation.setContent("12222");
        cooperation.setType(1);
        cooperation.setTitle("张三");
        cooperation.setPhoto("https://baidu.com");
        cooperationService.insert(cooperation);
    }

    @Test
    public void testGet() {
        Cooperation cooperation = cooperationMapper.selectById(12);
        System.out.println(cooperation);

    }

    @Test
    public void testUpdate() {
        Cooperation cooperation = cooperationService.get(11);
        cooperation.setType(2);
        cooperation.setTitle("xxx");
        cooperation.setPhoto("baidu.com");
        cooperation.setUpdateBy(2);
        cooperation.setUpdateTime(new Date());
        cooperation.setContent("3232323232");
        cooperationService.update(cooperation);
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
        System.out.println(cooperationService.getCounts());
    }



}
