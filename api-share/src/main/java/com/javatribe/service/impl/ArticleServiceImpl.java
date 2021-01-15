package com.javatribe.service.impl;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.mapper.ArticleMapper;
import com.javatribe.po.Article;
import com.javatribe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 获取文章的总数
     *
     * @return
     */
    @Override
    public int getTotalCount() {
        return articleMapper.getTotalCount();
    }

    /**
     * 获取模糊查询命中的总数
     *
     * @param artTitle
     * @return
     */
    @Override
    public int getCountLimitByTitle(String artTitle) {
        return articleMapper.getCountLimitByTitle(artTitle);
    }

    /**
     * 首页展示
     * TODO 分页，而且默认显示所有分类
     *
     * @param curPage 当前页
     * @param size 页面大小
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
        return entity;
    }

    /**
     * 按照标签展示文章摘要
     * TODO 分页显示
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
        System.out.println("category:" + category);
        List<Article> list = articleMapper.getSummarysByParentTag(category, entity.getCurPage(), size);
        entity.setList(list);
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
