package com.javatribe.apicompetition.controller;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * TODO:比赛介绍
 *
 * @Author lyr
 * @create 2021/1/16 15:44
 */
@RestController
@RequestMapping("/competition/")
@RequiredArgsConstructor
public class CompetitionIntroductionController {
    final CompetitionIntroductionService competitionIntroductionService;


    /**
     * 首页展示数据
     *
     * {
     *   "competitionId": 0,
     *   "competitionName": "",
     *   "showContent": "",
     *   "deleteStatus": false,
     *   "gmtCreate": "2021-01-31 17:23:58",
     *   "gmtModified": "2021-01-31 17:23:58",
     *   "signUp": 0,
     *
     * }
     *
     * showContent 展示内容
     * competitionName  比赛名字
     * signUp 表示 是否可以这里报名
     *
     *
     * @return
     */
    @GetMapping("/competition_introduce")
    public Result<List<CompetitionIntroduction>> firstPageInfo() {
        return Result.success(competitionIntroductionService.firstPageShow());
    }




    //---上面是官网首页
    //-----下面是管理端的接口
    //TODO: 管理端


    /**
     * 保存 competition
     * @param competitionIntroduction
     * @return
     */
    @PostMapping("/competition")
    public Result setCompetition(CompetitionIntroduction competitionIntroduction) {
        competitionIntroductionService.insertCompetitionInfo(competitionIntroduction);
        return Result.success();

    }
    @PutMapping("/competition")
    public Result updateById(CompetitionIntroduction competitionIntroduction) {
        competitionIntroductionService.updateCompetitionInfo(competitionIntroduction);
        return Result.success();
    }
    @DeleteMapping("/competition/{id}")
    public Result deleteCompetitionById(@PathVariable Long id) {
        competitionIntroductionService.deleteCompetitionInfoById(id);
        return Result.success();
    }

    /**
     * 添加比赛
     * @param competition
     * @return
     */
    @PutMapping("/addCompetition")
    public Result addCompetition(CompetitionIntroduction competition){
        return competitionIntroductionService.addCompetition(competition);
    }



}
