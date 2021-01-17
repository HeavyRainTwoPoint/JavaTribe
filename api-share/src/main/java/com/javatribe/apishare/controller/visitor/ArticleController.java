package com.javatribe.apishare.controller.visitor;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.service.ArticleService;
import com.javatribe.apishare.vo.ArticleAndTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/15 21:00
 */
@RestController
@RequestMapping("/share/visit")
public class ArticleController {
    private static final int DEFAULT_SIZE = 10;
    private static final int MIN_PAGE = 1;
    @Autowired
    private ArticleService articleService;

    /**
     * 第一次访问的时候没有分类，默认展示
     * @param curPage
     * @param size
     * @return
     */
    @GetMapping("/index")
    public Result<PageEntity> index(@PathParam("curPage")int curPage, @PathParam("size")int size) {
        curPage = isValid(curPage, true);
        size = isValid(size, false);
        PageEntity<Article> entity = articleService.getSummarys(curPage, size);
        return entity.getList() == null
                ? new Result(ApiInfo.BASIC_ERROR.getCode(), "没有更多啦~", entity)
                : Result.success(entity);
    }

    /**
     * 按照首页的标签去筛选文章
     * @param tagId 可以是一级的标签，也可以是二级的标签
     * @param curPage 当前页
     * @param size 页面大小。默认是10
     * @return
     */
    @GetMapping("/index/explore")
    public Result<PageEntity> index(@PathParam("tagId")int tagId, @PathParam("curPage")int curPage, @PathParam("size")int size) {
        curPage = isValid(curPage, true);
        size = isValid(size, false);
        PageEntity<Article> entity = articleService.getSummarysByTagId(tagId, curPage, size);
        return entity.getList() == null
                ? new Result(ApiInfo.BASIC_ERROR.getCode(), "没有更多啦~", entity)
                : Result.success(entity);
    }


    /**
     * 根据文章的编号查看文章的详情
     * @param artNo 文章编号，要求非空，不为空字符串
     * @return
     */
    @GetMapping("/detail")
    public Result<ArticleAndTags> detail(@PathParam("artNo")String artNo) {
        if (artNo == null || "".equals(artNo.trim())) {
            return new Result(ApiInfo.BASIC_ERROR.getCode(), "文章的编号不能为空！", null);
        }
        return Result.success(articleService.selectOneByArtNo(artNo));
    }

    @GetMapping("/search")
    public Result search(@PathParam("artTitle")String artTitle, @PathParam("curPage")int curPage, @PathParam("size")int size) {
        curPage = isValid(curPage, true);
        size = isValid(size, false);
        boolean isValid = isValid(artTitle);
        if (!isValid) {
            return Result.fail("搜索的内容不能为空！");
        }
        return Result.success(articleService.searchByTitle(artTitle, curPage, size));
    }

    /**
     * 数据的有效判断
     * @param target
     * @param flag  为true时：target表示curPage，判断是否大于0
     *              为false时：target表示size，判断是否为10
     */
    private int isValid(int target, boolean flag) {
        return flag ?
                target > 0 ? target : MIN_PAGE
                :
                target == DEFAULT_SIZE ? target : DEFAULT_SIZE;
    }

    /**
     * 重载上面的方法，作为字符串的校验并且返回布尔值
     * @param string 不能为空或者为空白字符串
     * @return
     */
    private boolean isValid(String string) {
        if (string == null || "".equals(string.trim())) {
            return false;
        }
        return true;
    }

}
