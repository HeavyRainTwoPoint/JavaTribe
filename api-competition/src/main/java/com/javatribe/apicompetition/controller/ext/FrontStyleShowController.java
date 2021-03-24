package com.javatribe.apicompetition.controller.ext;

import com.github.pagehelper.PageHelper;
import com.javatribe.apicommon.dto.PageEntity;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.vo.FrontStyleShowVO;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/3/24 21:36
 */
@AllArgsConstructor
@RestController
@RequestMapping("/front/styleShow")
public class FrontStyleShowController {
    final TribeStyleShowService styleShowService;

    /**
     * 前端风采展示
     * @return
     */
    @GetMapping("/all")
    public Result<List<FrontStyleShowVO>> getFirstPageData() {
        return Result.success( styleShowService.getAllStyleShowFronted());
    }

    @GetMapping("/resultList")
    public Result<?> getByPage(@RequestParam Integer page, @RequestParam Integer size) {
        PageHelper.startPage(page,size);
        return Result.success(PageEntity.of(styleShowService.getAllStyleShowFronted()));
    }


}
