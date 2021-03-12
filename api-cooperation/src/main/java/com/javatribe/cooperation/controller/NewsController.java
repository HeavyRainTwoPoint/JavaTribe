package com.javatribe.cooperation.controller;

import com.javatribe.cooperation.bean.bo.NewsBO;
import com.javatribe.cooperation.bean.dto.ApiResult;
import com.javatribe.cooperation.bean.dto.ApiResults;
import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.bean.entity.News;
import com.javatribe.cooperation.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Cooperation)表控制层
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Slf4j
@RestController
@RequestMapping("news")
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping("insert")
    public ApiResult insert(@RequestBody NewsBO newsBO) {
        newsBO.setId(null);
        News news = new News();
        BeanUtils.copyProperties(newsBO, news);
        //todo
        news.setCreateBy(1);
        news.setUpdateBy(1);
        newsService.insert(news);
        return ApiResults.success();
    }

    @PostMapping("update")
    public ApiResult update(@RequestBody NewsBO newsBO) {
        if (newsBO.getId() == null) {
            return ApiResults.badRequest("要修改的数据id不存在");
        } else {
            News news = newsService.get(newsBO.getId());
            if (news == null) {
                return ApiResults.badRequest("id所在数据不存在");
            }
            BeanUtils.copyProperties(news, newsBO);
            //todo
            news.setUpdateBy(1);
            news.setUpdateTime(new Date());
            newsService.update(news);
        }
        return ApiResults.success();
    }


    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Integer id) {
        newsService.delete(id);
        return ApiResults.success();
    }

    @GetMapping("/{id}")
    public ApiResult get(@PathVariable Integer id) {
        return ApiResults.success(newsService.get(id));
    }

    @GetMapping("getAll")
    public ApiResult getAll() {
        return ApiResults.success(newsService.getAll());
    }

    @GetMapping("page")
    public ApiResult page(@Param("page") Integer page,@Param("size") Integer size) {
        return ApiResults.success(newsService.page(page,size));
    }

    @GetMapping("getTopNews")
    public ApiResult getTopNews() {
        return ApiResults.success(newsService.getTopNews());
    }

    @GetMapping("getCounts")
    public ApiResult getCounts() {
        return ApiResults.success(newsService.getCounts());
    }
}
