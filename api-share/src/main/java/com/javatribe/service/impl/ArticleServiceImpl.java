package com.javatribe.service.impl;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.mapper.ArticleMapper;
import com.javatribe.po.Article;
import com.javatribe.service.ArticleService;
import com.javatribe.vo.ArticleAndTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 首页展示
     *
     * @param curPage 当前页
     * @param size    页面大小
     * @return
     */
    @Override
    public PageEntity<Article> getSummarys(int curPage, int size) {
        int totalCount = articleMapper.getTotalCount();
        PageEntity<Article> entity = init(curPage, size, totalCount);
        if (curPage > entity.getPages()) {
            curPage = entity.getPages();
            entity.setCurPage(curPage);
            return entity;
        }
        List<Article> list = articleMapper.getSummarys(entity);
        entity.setList(list);
        entity.setCurPage(curPage);
        return entity;
    }

    /**
     * 按照标签展示文章摘要
     *
     * @param category
     * @param curPage
     * @param size
     * @return
     */
    @Override
    public PageEntity<Article> getSummarysByParentTag(String category, int curPage, int size) {
        int totalCount = articleMapper.getCountLimitCategory(category);
        PageEntity<Article> entity = init(curPage, size, totalCount);
        if (curPage > entity.getPages()) {
            curPage = entity.getPages();
            entity.setCurPage(curPage);
            entity.setList(null);
            return entity;
        }
        List<Article> list = articleMapper.getSummarysByParentTag(category, entity.getCurPage(), size);
        entity.setList(list);
        entity.setCurPage(curPage);
        return entity;
    }

    /**
     * 获取某标签下的所有文章，分页返回
     *
     * @param tagId   给定的标签tagId
     * @param curPage 当前页
     * @param size    页面大小
     * @return
     */
    @Override
    public PageEntity<Article> getSummarysByTagId(int tagId, int curPage, int size) {
        int totalCount = articleMapper.getCountLimitByTagId(tagId);
        PageEntity<Article> entity = init(curPage, size, totalCount);
        if (curPage > entity.getPages()) {
            curPage = entity.getPages();
            entity.setCurPage(curPage);
            entity.setList(null);
            return entity;
        }
        Map<String, Integer> map = new HashMap<>(3);
        map.put("tagId", tagId);
        map.put("curPage", entity.getCurPage());
        map.put("size", size);
        List<Article> list = articleMapper.getSummarysByTagId(map);
        entity.setList(list);
        entity.setCurPage(curPage);
        return entity;
    }

    /**
     * 根据id获取一篇文章
     *
     * @param artNo 文章的id
     * @return
     */
    @Override
    public Article selectOneByNo(String artNo) {
        return articleMapper.selectOneByNo(artNo);
    }

    /**
     * 根据文章编号获取文章详情
     *
     * @param artNo 文章编号
     * @return
     */
    @Override
    public ArticleAndTags selectOneByArtNo(String artNo) {
        return articleMapper.selectOneByArtNo(artNo);
    }

    /**
     * 按照输入标题进行模糊查找
     *
     * @param artTitle 需要查找的标题
     * @return
     */
    @Override
    public PageEntity<Article> searchByTitle(String artTitle, int curPage, int size) {
        int totalCount = articleMapper.getCountLimitByTitle(artTitle);
        PageEntity<Article> entity = init(curPage, size, totalCount);
        if (curPage > entity.getPages()) {
            curPage = entity.getPages();
            entity.setCurPage(curPage);
            entity.setList(null);
            return entity;
        }
        List<Article> list = articleMapper.searchByArtTitle(artTitle, entity.getCurPage(), size);
        entity.setList(list);
        entity.setCurPage(curPage);
        return entity;
    }

    /**
     * 只是所有返回PageEntity的方法都需要经过同样的封装
     * 所以将一些重复代码封装一下
     * @param curPage 当前页
     * @param size 页面大小
     * @param totalCount 某个条件下的记录条数
     * @return
     */
    private PageEntity<Article> init(int curPage, int size, int totalCount) {
        PageEntity<Article> entity = new PageEntity<>();
        entity.setCurPage((curPage - 1) * size);
        entity.setSize(size);
        entity.setTotal(totalCount);
        if (totalCount % size == 0) {
            entity.setPages(totalCount / size);
        } else {
            entity.setPages((totalCount / size) + 1);
        }
        return entity;
    }
}
