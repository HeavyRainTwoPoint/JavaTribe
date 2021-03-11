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

    public List<News> page(Integer page) {
        return newsMapper.getByPages(page * 3, 3);
    }

    public List<News> getTopNews() {
        return newsMapper.getTopNews(2);
    }

    public Integer getCounts() {
        return newsMapper.getCounts();
    }

}
