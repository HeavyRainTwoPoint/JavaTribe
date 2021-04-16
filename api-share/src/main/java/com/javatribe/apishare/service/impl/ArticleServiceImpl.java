package com.javatribe.apishare.service.impl;

import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.apishare.mapper.ArtTagMapper;
import com.javatribe.apishare.mapper.ArticleMapper;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.service.ArticleService;
import com.javatribe.apishare.service.TagService;
import com.javatribe.apishare.utils.ArticleNoGenerator;
import com.javatribe.apishare.vo.ArticleAndTags;
import com.javatribe.apishare.vo.TagsRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired(required = false)
    private ArtTagMapper artTagMapper;

    @Autowired(required = false)
    private TagService tagService;

    /**
     * 根据文章No对文章进行逻辑删除
     *
     * @param artNo 文章编号
     * @return
     */
    @Override
    public int deleteOneByArtNo(String artNo) {
        int artId = articleMapper.getArtIdByNo(artNo);
        int result = articleMapper.deleteOneByArtNo(artNo);
        if (result == 1) {
            artTagMapper.deleteRelationshipByArtId(artId);
        }
        return result;
    }

    /**
     * 插入一篇新的文章
     *
     * @param articleAndTags 文章及其带的标签
     * @return 返回插入结果，1表示成功，0表示失败
     */
    @Override
    public int insertArticle(ArticleAndTags articleAndTags) {
            Article article = articleAndTags.getArticle();
            String artNo = ArticleNoGenerator.createNo();
            List<Integer> tags  = new ArrayList<>(articleAndTags.getTags().size());
            article.setArtNo(artNo);
            //PS：这里是为了获取一级标签的名字，需要借助二级标签的id来查询数据
            int tagId = articleAndTags.getTags().get(0).getTagParent();
            String tagName = tagService.getTagNameById(tagId);
            if (tagName == null) {
                //防止获取标签名这里返回null数据而出现异常
                return 0;
            }
            article.setArtTagName(tagName);
            articleAndTags.getTags().forEach(tag -> {
                tags.add(tag.getTagId());
            });
            tags.add(tagId);
            //以上逻辑可以修改为更简洁的，只是项目后期修改牵一发动全身
            int result = articleMapper.insertArticle(article);
            if (result == 1) {
                artTagMapper.insertTags(new TagsRelationship(article.getArtId(), tags));
            }
            return result;
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
     * 通过文章编号获取阅读数
     *
     * @param artNo 文章编号
     * @return
     */
    @Override
    public int getViewCountByArtNo(String artNo) {
        return articleMapper.getViewCountByArtNo(artNo);
    }

    /**
     * 通过文章编号更新阅读数
     *
     * @param artNo        文章编号
     * @param newViewCount 新的阅读数
     * @return
     */
    @Override
    public int updateViewCountByArtNo(String artNo, int newViewCount) {
        return articleMapper.updateViewCountByArtNo(artNo, newViewCount);
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

    /**
     * 根据文章编号修改文章
     *
     * @param article 文章
     * @return
     */
    @Override
    public int updateArtByNo(Article article) {
        return articleMapper.updateArtByNo(article);
    }
}
