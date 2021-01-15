package com.javatribe.mapper;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.po.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
     * 获取文章的总数
     * @return
     */
    int getTotalCount();

    /**
     * 获取模糊查询命中的总数
     * @param artTitle
     * @return
     */
    int getCountLimitByTitle(String artTitle);

    /**
     * 获取某个一级标签下的所有文章
     * @param category
     * @return
     */
    int getCountLimitCategory(String category);

    /**
     * 根据id获取一篇文章
     * @param artNo 文章的id
     * @return
     */
    Article selectOneByNo(String artNo);

    /**
     * 首页展示
     * TODO 分页，而且默认显示所有分类
     * @return
     */
    List<Article> getSummarys(PageEntity<Article> pageEntity);

    /**
     * 按照标签展示文章摘要
     * TODO 分页显示
     * @return
     */
    List<Article> getSummarysByParentTag(String category, int curPage, int size);
//
//
//    /**
//     * 按照输入标题进行模糊查找
//     * TODO 分页
//     * @param artTitle
//     * @return
//     */
//    List<Article> searchByTitle(String artTitle);



}