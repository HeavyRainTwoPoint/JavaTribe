package com.javatribe.apicompetition.controller.front;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * 前端风采展示， 返回 年份月份 和比赛信息之类的
     * @return
     */
    @GetMapping("/styleshow_info")
    public Result<List<CompetitionAndYearsVO>> listCompetitionAndYears() {
        return Result.success(competitionIntroductionService.listCompetitionAndYearsVo());

    }

}
