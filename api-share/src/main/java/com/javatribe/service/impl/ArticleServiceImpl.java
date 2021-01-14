package com.javatribe.service.impl;

import com.javatribe.mapper.ArticleMapper;
import com.javatribe.po.Article;
import com.javatribe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/14 14:41
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    /**
     * 根据文章id对文章进行逻辑删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOneById(Integer id) {
        return articleMapper.deleteOneById(id);
    }

    /**
     * 插入一篇新的文章
     *
     * @param article 文章
     * @return 返回插入结果，1表示成功，0表示失败
     */
    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    /**
     * 根据id获取一篇文章
     *
     * @param id 文章的id
     * @return
     */
    @Override
    public Article selectOneById(int id) {
        return articleMapper.selectOneById(id);
    }
}
