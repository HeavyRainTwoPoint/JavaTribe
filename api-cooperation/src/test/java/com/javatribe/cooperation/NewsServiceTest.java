package com.javatribe.cooperation;

import com.javatribe.cooperation.bean.entity.News;
import com.javatribe.cooperation.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author LCW
 * @since 2021/3/11 13:19
 **/
@SpringBootTest
class NewsServiceTest {

    @Resource
    private NewsService newsService;

    @Test
    public void insertTest() {
        News news = new News();
        news.setUpdateTime(new Date());
        news.setCreateTime(new Date());
        news.setUpdateBy(1);
        news.setCreateBy(1);
        news.setUrl("1222sadsds2");
        news.setPriority(1);
        news.setTitle("张dsds三");
        news.setPhoto("https://bdsdaidu2232.com");
        newsService.insert(news);
    }
    @Test
    public void testGet() {
        System.out.println(newsService.get(1));
    }

    @Test
    public void testUpdate() {
        News news = newsService.get(1);
        news.setPriority(0);
        news.setUrl("xxxxx");
        news.setUpdateBy(2);
        news.setTitle("李四");
        news.setPhoto("xxx");
        newsService.update(news);

    }

    @Test
    public void testDelete() {
        newsService.delete(2);
    }

    @Test
    public void testGetAll() {
        System.out.println(newsService.getAll());
    }

    @Test
    public void testPage() {
        System.out.println(newsService.page(0,10));
    }

    @Test
    public void testGetTopNews() {
        System.out.println(newsService.getTopNews());
    }

    @Test
    public void getCounts() {
        System.out.println(newsService.getCounts());
    }





}
