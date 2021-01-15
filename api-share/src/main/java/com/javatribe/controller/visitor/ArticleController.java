package com.javatribe.controller.visitor;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.po.Article;
import com.javatribe.service.ArticleService;
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

    @GetMapping("/index")
    public Result<PageEntity> index(@PathParam("curPage")int curPage, @PathParam("size")int size) {
        if (size != DEFAULT_SIZE) {
            size = DEFAULT_SIZE;
        }
        if (curPage < MIN_PAGE) {
            curPage = MIN_PAGE;
        }
        PageEntity<Article> entity = articleService.getSummarys(curPage, size);
        return entity.getList() == null
                ? new Result(ApiInfo.BASIC_ERROR.getCode(), "没有更多啦~", entity)
                : Result.success(entity);
    }

    //TODO 文档未写，还需要深度测试一下
    @GetMapping("/index/explore")
    public Result<PageEntity> index(@PathParam("category")String category, @PathParam("curPage")int curPage, @PathParam("size")int size) {
        if (size != DEFAULT_SIZE) {
            size = DEFAULT_SIZE;
        }
        if (curPage < MIN_PAGE) {
            curPage = MIN_PAGE;
        }
        System.out.println(category);
        PageEntity<Article> entity = articleService.getSummarysByParentTag(category, curPage, size);
        return entity.getList() == null
                ? new Result(ApiInfo.BASIC_ERROR.getCode(), "没有更多啦~", entity)
                : Result.success(entity);
    }

}
