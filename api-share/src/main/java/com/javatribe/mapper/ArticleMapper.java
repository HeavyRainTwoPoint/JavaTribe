package com.javatribe.mapper;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.po.Article;
import com.javatribe.vo.ArticleAndTags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
     * 统计某标签的文章总数
     * @param tagId 某个标签的tagId
     * @return
     */
    int getCountLimitByTagId(int tagId);

    /**
     * 根据id获取一篇文章
     * @param artNo 文章的id
     * @return
     */
    Article selectOneByNo(String artNo);

    /**
     * 首页展示
     * @return
     */
    List<Article> getSummarys(PageEntity<Article> pageEntity);

    /**
     * 按照标签显示文章摘要
     * @param category
     * @param curPage 默认是第一页
     * @param size
     * @return
     */
    List<Article> getSummarysByParentTag(String category, int curPage, int size);

    /**
     * 获取某标签下的所有文章，分页返回
     * @param map 包含某个标签的tagId，当前页curPage, 页面大小size
     * @return
     */
    List<Article> getSummarysByTagId(Map<String, Integer> map);

    /**
     * 根据文章编号获取文章详情
     * @param artNo 文章编号
     * @return
     */
    ArticleAndTags selectOneByArtNo(String artNo);

    /**
     * 根据标题模糊查询
     * @param artTitle 标题
     * @param curPage 想要查询的页面
     * @param size 页面大小
     * @return
     */
    List<Article> searchByArtTitle(String artTitle, int curPage, int size);

}