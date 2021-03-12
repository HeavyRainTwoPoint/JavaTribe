package com.javatribe.cooperation.service;

import com.javatribe.cooperation.bean.entity.News;
import com.javatribe.cooperation.mapper.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    public void insert(News record) {
        record.setUpdateTime(new Date());
        record.setCreateTime(new Date());
        newsMapper.insert(record);
    }

    public News get(Integer id) {
        return newsMapper.selectById(id);
    }

    public void update(News old) {
        old.setUpdateTime(new Date());
        newsMapper.update(old);
    }

    public void delete(Integer id) {
        newsMapper.delete(id);
    }

    public List<News> getAll() {
        return newsMapper.getAll();
    }

    public List<News> page(Integer page,Integer size) {
        return newsMapper.getByPages(page * size, size);
    }

    public List<News> getTopNews() {
        return newsMapper.getTopNews(2);
    }

    public Integer getCounts(Integer priority) {
        return newsMapper.getCounts(priority);
    }

    public  List<News>  getLowPriorityPage(Integer page, Integer size) {
        return newsMapper.getLowPriorityPage(page * size, size);
    }

    public Integer getAllCounts() {
        return newsMapper.getAllCounts();
    }
}
