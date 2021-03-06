package com.javatribe.apilife.controller;

import com.javatribe.apilife.dto.ActivityDTO;
import com.javatribe.apilife.dto.Result;
import com.javatribe.apilife.expt.SwapException;
import com.javatribe.apilife.service.LifeInfoManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/life")
public class LifeInfoManipulationController {

    @Autowired
    LifeInfoManipulation lifeInfoManipulation;

    @PostMapping("/life-info")
    public Result insertLifeInfo(@RequestBody(required = false) ActivityDTO dto) {
        lifeInfoManipulation.insertActivity(dto);
        return Result.ok();
    }

    @PutMapping("/life-info")
    public Result updateLifeInfo(@RequestBody(required = false) ActivityDTO dto) {
        lifeInfoManipulation.updateActivityById(dto);
        return Result.ok();
    }


    @DeleteMapping("/life-info/{id}")
    public Result deleteLifeInfoById(@PathVariable("id") int id) {
        lifeInfoManipulation.deleteActivityById(id);
        return Result.ok();
    }

    @PutMapping("/priority/move-up/{id}")
    public Result moveUp(@PathVariable("id") int id) {
        try {
            lifeInfoManipulation.priorityMoveUp(id);
        } catch (Exception e) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage(e.getMessage());
            return result;
        }
        return Result.ok();
    }

    @PutMapping("/priority/move-down/{id}")
    public Result moveDown(@PathVariable("id") int id) {
        try {
            lifeInfoManipulation.priorityMoveDown(id);
        } catch (SwapException e) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage(e.getMessage());
            return result;
        }
        return Result.ok();
    }


    @PutMapping("/priority/swap")
    public Result moveDown(@RequestParam("a") int a, @RequestParam("b") int b) {
        lifeInfoManipulation.prioritySwap(a, b);
        return Result.ok();
    }

}
