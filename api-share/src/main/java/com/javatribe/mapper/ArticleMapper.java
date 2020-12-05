package com.javatribe.mapper;

import com.javatribe.pojo.Article;


public interface ArticleMapper {
//    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一篇新的文章
     * @param article 文章
     * @return 返回插入结果，1表示成功，0表示失败
     */
    int insertArticle(Article article);
    int selectOneById(int id);

//    int insertSelective(Article record);

//    Article selectByPrimaryKey(Integer id);

//    int updateByPrimaryKeySelective(Article record);

//    int updateByPrimaryKey(Article record);
}