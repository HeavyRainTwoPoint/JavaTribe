package com.javatribe.apilife.controller;

import com.javatribe.apilife.dao.ActivityDao;
import com.javatribe.apilife.dao.TagDao;
import com.javatribe.apilife.dto.Result;
import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.pojo.Tag;
import com.javatribe.apilife.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/life")
public class PriorityController {

    @Autowired
    PriorityService<Tag> priorityService;

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

    @GetMapping("/all")
    public Result all() {
        Result result = new Result();
        result.setData(priorityService.getAllQueue());
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    @Autowired
    TagDao tagDao;

    @GetMapping("/afresh")
    public Result afresh() {
        final HashMap map = priorityService.afreshQueue(tagDao.selectAll());
        final Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(map);
        return result;
    }

    @PostMapping("/add")
    public Result addTest() {
        final Result result = new Result();
        int nextPriority = priorityService.nextPriority(0);
        Tag t = new Tag(11, 0, nextPriority, "5");
        priorityService.addNode(t);
        nextPriority = priorityService.nextPriority(4);
        t = new Tag(12, 4, nextPriority, "!");
        priorityService.addNode(t);
        nextPriority = priorityService.nextPriority(1);
        t = new Tag(13, 1, nextPriority, "#");
        priorityService.addNode(t);
        result.setCode(200);
        result.setMessage("成功");
        result.setData(priorityService.getAllQueue());
        return result;
    }

    @DeleteMapping("/delete")
    public Result deleteTest(@RequestParam("id")int id){
        final Result result = new Result();
        priorityService.delNode(id);
        result.setCode(200);
        result.setMessage("成功");
        result.setData(priorityService.getAllQueue());
        return result;
    }
}
