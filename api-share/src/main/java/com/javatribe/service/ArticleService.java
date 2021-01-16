package com.javatribe.service;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.po.Article;
import com.javatribe.vo.ArticleAndTags;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:07
 */

public interface ArticleService {
    /**
     * 根据文章id对文章进行逻辑删除
     *
     * @param id
     * @return
     */
    int deleteOneById(Integer id);

    /**
     * 插入一篇新的文章
     *
     * @param article 文章
     * @return 返回插入结果，1表示成功，0表示失败
     */
    int insertArticle(Article article);

    /**
     * 根据id获取一篇文章
     *
     * @param artNo 文章的id
     * @return
     */
    Article selectOneByNo(String artNo);

    /**
     * 首页展示
     *
     * @return
     */
    PageEntity<Article> getSummarys(int curPage, int size);

    /**
     * 按照标签展示文章摘要
     *
     * @return
     */
    PageEntity<Article> getSummarysByParentTag(String category, int curPage, int size);

    /**
     * 获取某标签下的所有文章，分页返回
     *
     * @param tagId   给定的标签tagId
     * @param curPage 当前页
     * @param size    页面大小
     * @return
     */
    PageEntity<Article> getSummarysByTagId(int tagId, int curPage, int size);


    /**
     * 按照输入标题进行模糊查找
     * @param artTitle 模糊查询的title
     * @param curPage 想要查看的下一页
     * @param size 页面大小
     * @return
     */
    PageEntity<Article> searchByTitle(String artTitle, int curPage, int size);

    /**
     * 根据文章编号获取文章详情
     * @param artNo 文章编号
     * @return
     */
    ArticleAndTags selectOneByArtNo(String artNo);
}
