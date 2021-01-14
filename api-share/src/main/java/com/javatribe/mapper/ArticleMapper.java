package com.javatribe.mapper;

import com.javatribe.po.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小胖五
 */
public interface ArticleMapper {
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

//    int insertSelective(Article record);

//    Article selectByPrimaryKey(Integer id);

//    int updateByPrimaryKeySelective(Article record);

//    int updateByPrimaryKey(Article record);
}