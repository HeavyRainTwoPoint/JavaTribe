package com.javatribe.apicompetition.controller;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/competition_introduce")
    public Result<List<CompetitionIntroduction>> firstPageInfo() {
        return Result.success(competitionIntroductionService.firstPageShow());
    }

    //---上面是官网首页
    //-----下面是管理端的接口
    //TODO: 管理端



}
