package com.javatribe.service;

import com.javatribe.po.Article;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:07
 */

public interface ArticleService {
    /**
     * 根据文章id对文章进行逻辑删除
     * @param id
     * @return
     */
    int deleteOneById(Integer id);

    /**
     * 插入一篇新的文章
     * @param article 文章
     * @return 返回插入结果，1表示成功，0表示失败
     */
    int insertArticle(Article article);

    /**
     * 根据id获取一篇文章
     * @param id 文章的id
     * @return
     */
    Article selectOneById(int id);
}
