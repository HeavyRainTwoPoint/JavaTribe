package com.javatribe.apicompetition.controller;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.dto.StyleShowDTO;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import com.javatribe.apicompetition.util.BeanMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部落风采展示模块
 * TODO: 风采展示
 * @Author lyr
 * @create 2021/1/16 15:48
 */
@RestController
@RequiredArgsConstructor
public class StyleShowController {
    final TribeStyleShowService styleShowService;
    final BeanMapperUtils beanMapperUtils /*= Mappers.getMapper(BeanMapperUtils.class)*/;


    /**
     * 官网获取首页
     * 数据
     *
     *
     * {
     *   "showId": 0,
     *   "competitionId": 0,
     *   "gmtCreate": "2021-01-31 17:23:58",
     *   "gmtModified": "2021-01-31 17:23:58",
     *   "showStatus": false,
     *   "deleteStatus": false,
     *   "showOrder": 0,
     *   "imgs": "",
     *   "projectName": "",
     *   "teamName": "",
     *   "teamMembers": "",
     *   "teamBeginTime": "2021-01-31 17:23:58",
     *   "teamEndTime": "2021-01-31 17:23:58",
     *   "theYear": "",
     *
     * }
     * competitionId -> 引用的 比赛 ID  competitionIntroduction页面
     * showStatus -> 为 true ，则展示在 首页，默认为 true
     * deleteStatus -> 逻辑删除
     * showOrder  -》用来排序的，还没用过
     * imgs  -> 图片链接，
     * projectName -> 项目名字
     * teamName -> 队伍名字
     * teamMembers -> 队伍其他人名字
     * teamBeginTime 和 endTime 表示队伍 比赛时间
     * theYear 表示第几届
     *
     *
     *
     * @return
     */
    @GetMapping("style_show")
    public Result<List<StyleShowVO>> styleShowPage(/*@PathParam("page") Integer page, @PathParam("size") Integer size*/) {
        List<StyleShowVO> list = styleShowService.getAllStyleShow();
        return Result.success(list);
    }

    /**
     * 根据比赛 ID 获取风采展示的届数
     * @param competitionId
     * @return
     */
    @GetMapping("/styleShowYears")
    public Result<List<Integer>> getAllStyleShowTheYears(@RequestParam Integer competitionId) {
        return styleShowService.getAllStyleShowYears(competitionId);
    }

    @GetMapping("/styleShow_searchBy")
    public Result<List<StyleShowVO>> getStyleShowByCompetitionIdAndTheYear(@RequestParam String theYear, @RequestParam Integer competitionId) {
        return styleShowService.getAllStyleShowVOByCompetitionIdAndTheYear(theYear,competitionId);
    }

    // /**
    //  * 管理员更新后台队伍风采数据
    //  * @param styleShow
    //  * @return
    //  */
    // @PutMapping("/styleShow")
    // public Result updateStyleShow(@RequestBody StyleShow styleShow) {
    //     styleShowService.updateById(styleShow);
    //     return Result.success();
    // }

    /**
     * 插入一条记录
     * @return
     */
    @PostMapping("/styleShow")
    public Result insertOneStyleShowItem(@RequestBody StyleShowDTO styleShow) {
        if (styleShow.getShowId()==null) {
            //id  不为 null 就更新数据
            styleShowService.insertOne(beanMapperUtils.from(styleShow));
        }else {

            styleShowService.updateById(beanMapperUtils.from(styleShow));
        }
        return Result.success();
    }

    /**
     * 逻辑删除 数据
     * @param id     数据 主键
     * @return
     */
    @DeleteMapping("/styleShow/{id}")
    public Result deleteById(@PathVariable Long id) {
        styleShowService.deleteById(id);
        return Result.success();
    }




}
