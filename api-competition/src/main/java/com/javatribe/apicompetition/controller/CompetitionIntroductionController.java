package com.javatribe.apicompetition.controller;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.dto.CompetitionIntroductionDTO;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import com.javatribe.apicompetition.util.BeanMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO:比赛介绍
 *
 * @Author lyr
 * @create 2021/1/16 15:44
 */
@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionIntroductionController {
    final CompetitionIntroductionService competitionIntroductionService;
    final BeanMapperUtils mapperUtils; /*= Mappers.getMapper(BeanMapperUtils.class);*/


    /**
     * 首页展示数据
     * <p>
     * {
     * "competitionId": 0,
     * "competitionName": "",
     * "showContent": "",
     * "deleteStatus": false,
     * "gmtCreate": "2021-01-31 17:23:58",
     * "gmtModified": "2021-01-31 17:23:58",
     * "signUp": 0,
     * <p>
     * }
     * <p>
     * showContent 展示内容
     * competitionName  比赛名字
     * signUp 表示 是否可以这里报名
     *
     * @return
     */
    @GetMapping("/competition_introduce")
    public Result<List<CompetitionIntroduction>> firstPageInfo() {
        return Result.success(competitionIntroductionService.firstPageShow());
    }


    @GetMapping("/competition_detail/{compId}")
    public Result<CompetitionIntroduction> getCompetitionDetailInfo(@RequestParam(defaultValue = "html") String type, @PathVariable Integer compId) {
        if ("html".equalsIgnoreCase(type)) {
            //markdown 转 HTML 返回前端
            return Result.success(competitionIntroductionService.getCompetitionDetailInfoWithHtml(compId));
        }
        //else{
        //直接 返回 markdown 给前端
        return Result.success(competitionIntroductionService.getCompetitionDetailWithRawData(compId));
        //}
        //return Result.success(null);
    }


    //---上面是官网首页
    //-----下面是管理端的接口
    //TODO: 管理端


    /**
     * 保存 competition
     *
     * @param competitionIntroduction
     * @return
     */
    @PostMapping("/competition")
    public Result setCompetition(@RequestBody CompetitionIntroductionDTO competitionIntroduction) {

        // BeanUtils.copyProperties(db,competitionIntroduction);
        if (competitionIntroduction.getCompetitionId() == null) {
            // id 是 null 就 插入
            competitionIntroductionService.insertCompetitionInfo(mapperUtils.from(competitionIntroduction));
        } else {
            //否则就更新
            competitionIntroductionService.updateCompetitionInfo(mapperUtils.from(competitionIntroduction));
        }
        return Result.success();

    }

    // @PutMapping("/competition")
    // public Result updateById(@RequestBody CompetitionIntroduction competitionIntroduction) {
    //     competitionIntroductionService.updateCompetitionInfo(competitionIntroduction);
    //     return Result.success();
    // }
    @DeleteMapping("/competition/{id}")
    public Result deleteCompetitionById(@PathVariable Long id) {
        competitionIntroductionService.deleteCompetitionInfoById(id);
        return Result.success();
    }

    // /**
    //  * 添加比赛
    //  *
    //  * @param competition
    //  * @return
    //  */
    // @PutMapping("/addCompetition")
    // public Result addCompetition(CompetitionIntroduction competition) {
    //     return competitionIntroductionService.addCompetition(competition);
    // }


}
