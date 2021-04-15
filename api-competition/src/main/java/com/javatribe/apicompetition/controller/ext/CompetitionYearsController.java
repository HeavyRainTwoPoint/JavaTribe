package com.javatribe.apicompetition.controller.ext;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicommon.exception.ServiceException;
import com.javatribe.apicompetition.pojo.dto.CompetitionYearDTO;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import com.javatribe.apicompetition.util.BeanMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * 获取比赛风采展示有哪一届
 *
 * @Author lyr
 * @create 2021/3/23 23:58
 */
@RestController
@RequestMapping("/style_show_years")
@RequiredArgsConstructor
public class CompetitionYearsController {
    final TribeStyleShowService tribeStyleShowService;
    // final
    final BeanMapperUtils beanMapperUtils;

    /**
     *
     * 获取每个比赛的 风采展示【有哪些时间，，哪一届之类的
     *
     * @param competitionId
     * @return
     */
    @GetMapping("/years")
    public Result<List<CompetitionYear>> getALLYears(@RequestParam Integer competitionId) {
        return Result.success(tribeStyleShowService.getCompetitionYearsByCompetitionId(competitionId));
    }
    @com.javatribe.apicommon.annotation.SuperAuthentication
    @PostMapping("/years")
    public Result  updateOrInsert(@RequestBody CompetitionYearDTO json) {
        //接口校验  第一次插入，需要 设置 【时间】
        if (json.getYearId()==null  && (json.getYearEndTime()==null ||  json.getYearStartTime()==null  ) ) {
            throw new ServiceException(ApiInfo.BAD_REQUEST, "没有添加届数开始时间 或者 结束时间，无法插入数据");
        }



        tribeStyleShowService.updateOrInsertCompetitionYears(beanMapperUtils.from(json));
        return Result.success();
    }

    /**
     * 删除对应的届数
     * @param yearId
     * @return
     */
    @com.javatribe.apicommon.annotation.SuperAuthentication
    @DeleteMapping("/del_years")
    public Result deleteYears(@RequestParam Integer yearId) {
        tribeStyleShowService.deleteStyleShowCompetitionYears(yearId);
        return Result.success();
    }







}
