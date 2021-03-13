package com.javatribe.cooperation;

import com.javatribe.cooperation.bean.entity.News;
import com.javatribe.cooperation.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

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
        int flag = 0;
        for (int i = 0; i < 100; i++) {
            News news = new News();
            Random random = new Random();
            news.setUpdateBy(random.nextInt(1000000000));
            news.setCreateBy(random.nextInt(1000000000));
            news.setUrl("https://baidu.com");
            if (flag == 0) {
                news.setPriority(0);
                flag = 1;
            } else {
                news.setPriority(1);
                flag = 0;
            }
            news.setTitle("李四" + random.nextInt(10000) + "xxxx");
            news.setPhoto("http://img.1ppt.com/uploads/allimg/2103/1-210312131R80-L.jpg");
            newsService.insert(news);
        }
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
    public void getAllCounts() {
        System.out.println(newsService.getAllCounts());
    }
    @Test
    public void getCounts() {
        System.out.println(newsService.getCounts(1));
        System.out.println(newsService.getCounts(0));
    }

    @Test
    public void getLowPriorityPage() {
        System.out.println(newsService.getLowPriorityPage(0, 2));
    }
}
