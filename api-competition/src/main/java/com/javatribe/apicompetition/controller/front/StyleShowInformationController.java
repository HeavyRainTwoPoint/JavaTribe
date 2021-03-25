package com.javatribe.apicompetition.controller.front;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部落前端风采展示
 *
 * @Author lyr
 * @create 2021/3/25 10:04
 */
@AllArgsConstructor
@RestController
@RequestMapping("/front")
public class StyleShowInformationController {
    final CompetitionIntroductionService competitionIntroductionService;
    final TribeStyleShowService tribeStyleShowService;

    /**
     * 前端风采展示， 返回 年份月份 和比赛信息之类的
     * @return
     */
    @GetMapping("/styleshow_info")
    public Result<List<CompetitionAndYearsVO>> listCompetitionAndYears() {
        return Result.success(competitionIntroductionService.listCompetitionAndYearsVo());

    }




    @GetMapping("/competitions")
    public Result<List<StyleShow>> getByCompetitoinId(@RequestParam Integer competitionId) {
        return Result.success(tribeStyleShowService.listStyleShowByCompetition(competitionId));
    }


}
