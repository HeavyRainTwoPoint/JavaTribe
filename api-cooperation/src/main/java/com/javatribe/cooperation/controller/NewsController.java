package com.javatribe.cooperation.controller;

import com.javatribe.cooperation.bean.bo.NewsBO;
import com.javatribe.cooperation.bean.dto.ApiResult;
import com.javatribe.cooperation.bean.dto.ApiResults;
import com.javatribe.cooperation.bean.entity.News;
import com.javatribe.cooperation.bean.enums.NewsType;
import com.javatribe.cooperation.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 新闻表控制层
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

    /**
     * 插入新闻数据
     */
    @PostMapping("insert")
    public ApiResult insert(@RequestBody NewsBO newsBO) {
        if (newsBO.getPriority() != NewsType.HeightPriority.getType() || newsBO.getPriority() != NewsType.LowPriority.getType()) {
            newsBO.setPriority(NewsType.LowPriority.getType());
        }
        newsBO.setId(null);
        News news = new News();
        BeanUtils.copyProperties(newsBO, news);
        //todo  添加操作人信息
        news.setCreateBy(1);
        news.setUpdateBy(1);
        newsService.insert(news);
        return ApiResults.success();
    }

    /**
     *  更新新闻数据
     */
    @PostMapping("update")
    public ApiResult update(@RequestBody NewsBO newsBO) {
        if (newsBO.getId() == null) {
            return ApiResults.badRequest("要修改的数据id不存在");
        } else {
            News news = newsService.get(newsBO.getId());
            if (news == null) {
                return ApiResults.badRequest("id所在数据不存在");
            }
            if (newsBO.getPriority() != NewsType.HeightPriority.getType() || newsBO.getPriority() != NewsType.LowPriority.getType()) {
                newsBO.setPriority(NewsType.LowPriority.getType());
            }
            BeanUtils.copyProperties(news, newsBO);
            //todo  添加操作人信息
            news.setUpdateBy(1);
            newsService.update(news);
        }
        return ApiResults.success();
    }

    /**
     * 删除新闻
     */
    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Integer id) {
        newsService.delete(id);
        return ApiResults.success();
    }

    /**
     * 获取新闻的详细信息
     */
    @GetMapping("/{id}")
    public ApiResult get(@PathVariable Integer id) {
        return ApiResults.success(newsService.get(id));
    }

    /**
     * 获取全部数据
     */
    @GetMapping("getAll")
    public ApiResult getAll() {
        return ApiResults.success(newsService.getAll());
    }

    /**
     * 全部数据分页返回
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam("page") Integer page,@RequestParam("size") Integer size) {
        return ApiResults.success(newsService.page(page,size));
    }

    /**
     * 分页查询低优先级的数据
     */
    @GetMapping("getLowPriorityPage")
    public ApiResult getLowPriorityPage(@RequestParam("page") Integer page,@RequestParam("size") Integer size) {
        return ApiResults.success(newsService.getLowPriorityPage(page,size));
    }

    /**
     * 获取前两条优先级高的新闻
     */
    @GetMapping("getTopNews")
    public ApiResult getTopNews() {
        return ApiResults.success(newsService.getTopNews());
    }

    /**
     * 按优先级获取新闻数据个数
     */
    @GetMapping("getCounts")
    public ApiResult getCounts(@RequestParam("priority") Integer priority) {
        return ApiResults.success(newsService.getCounts(priority));
    }

    /**
     * 获取全部数据个数
     */
    @GetMapping("getAllCounts")
    public ApiResult getAllCounts() {
        return ApiResults.success(newsService.getAllCounts());
    }


}
