package com.javatribe.apilife.controller;

import com.javatribe.apilife.dto.Result;
import com.javatribe.apilife.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/life")
public class PriorityController {

    @Autowired
    PriorityService priorityService;

    /**
     * 1、判断是否是上一位
     * 2、进行交换
     *
     * @return 部落生活信息展示列表
     */
    @PutMapping("/moveUp")
    public Result moveUp(@RequestParam("id") int activityId) {
        Result result = new Result();
        priorityService.moveUp(activityId);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    @PutMapping("/moveDown")
    public Result moveDown(@RequestParam("id") int activityId) {
        Result result = new Result();
        priorityService.moveDown(activityId);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    /**
     * 优先级交换
     *
     * @param a a
     * @param b b
     * @return 交换结果
     */
    @PutMapping("/swap")
    public Result swap(@RequestParam("a") int a, @RequestParam("b") int b) {
        Result result = new Result();
        priorityService.swapPriority(a, b);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    @GetMapping("/test")
    public Result test(){
        Result result = new Result();
        result.setData(priorityService.getQueue());
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
}
