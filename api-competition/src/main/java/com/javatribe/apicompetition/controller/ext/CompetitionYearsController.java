package com.javatribe.apicompetition.controller.ext;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/3/23 23:58
 */
@RestController
@RequestMapping("/style_show_years")
@RequiredArgsConstructor
public class CompetitionYearsController {
    final TribeStyleShowService tribeStyleShowService;
    @GetMapping("/years")
    public Result<List<CompetitionYear>> getALLYears(@RequestParam Integer competitionId) {
        return Result.success(tribeStyleShowService.getCompetitionYearsByCompetitionId(competitionId));
    }

    @PostMapping("/years")
    public Result  updateOrInsert(@RequestBody CompetitionYear json) {
        tribeStyleShowService.updateOrInsertCompetitionYears(json);
        return Result.success();
    }
    @DeleteMapping("/del_years")
    public Result deleteYears(@RequestParam Integer yearId) {
        tribeStyleShowService.deleteStyleShowCompetitionYears(yearId);
        return Result.success();
    }

}
