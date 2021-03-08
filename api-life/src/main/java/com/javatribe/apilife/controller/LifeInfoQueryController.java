package com.javatribe.apilife.controller;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.service.LifeInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/life")
public class LifeInfoQueryController {

    @Autowired
    LifeInfoQueryService lifeInfoQueryService;

    @GetMapping("/life-infos")
    public Result allLifeInfos() {
        final List<Activity> data = lifeInfoQueryService.listActivitiesByPriority();
        return Result.success(data);
    }

    @GetMapping("/life-info/{id}")
    public Result allLifeInfoById(@PathVariable("id") int id) {
        final Activity data = lifeInfoQueryService.queryById(id);
        if (data == null) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage("对象不存在");
            return result;
        }
        return Result.success(data);
    }

    @GetMapping("/life-info/title/{title}")
    public Result allLifeInfoByName(@PathVariable("title") String title) {
        final Activity data = lifeInfoQueryService.queryByActTitle(title);
        if (data == null) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage("对象不存在");
            return result;
        }
        return Result.success(data);
    }

    @GetMapping("/life-info/exist/{title}")
    public Result isExist(@PathVariable("title") String title) {
        Result result = new Result();
        boolean isExist = lifeInfoQueryService.isExistTitle(title);
        if (isExist) {
            result.setCode(400);
            result.setMessage("标题已存在");
        } else {
            result.setCode(200);
            result.setMessage("标题可用");
        }
        return result;
    }


}
