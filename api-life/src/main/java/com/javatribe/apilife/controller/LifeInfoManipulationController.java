package com.javatribe.apilife.controller;

import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.SuperAuthentication;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apilife.dto.ActivityDTO;
import com.javatribe.apilife.expt.SqlException;
import com.javatribe.apilife.expt.SwapException;
import com.javatribe.apilife.service.LifeInfoManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/life")
public class LifeInfoManipulationController {

    @Autowired
    LifeInfoManipulation lifeInfoManipulation;

    @AdminAuthentication
    @SuperAuthentication
    @PostMapping("/life-info")
    public Result insertLifeInfo(@RequestBody(required = false) ActivityDTO dto) {
        try {
            lifeInfoManipulation.insertActivity(dto);
        } catch (SqlException e) {
            return Result.from(e.getMessage(), 400);
        }
        return Result.success();
    }

    @AdminAuthentication
    @SuperAuthentication
    @PutMapping("/life-info/")
    public Result updateLifeInfo(@RequestBody(required = false) ActivityDTO dto) {
        try {
            lifeInfoManipulation.updateActivityById(dto);
        } catch (SqlException e) {
            return Result.from(e.getMessage(), 400);
        }
        return Result.success();
    }

    @AdminAuthentication
    @SuperAuthentication
    @DeleteMapping("/life-info/{id}")
    public Result deleteLifeInfoById(@PathVariable("id") int id) {
        lifeInfoManipulation.deleteActivityById(id);
        return Result.success();
    }

    //    @PutMapping("/priority/move-up/{id}")
    public Result moveUp(@PathVariable("id") int id) {
        try {
            lifeInfoManipulation.priorityMoveUp(id);
        } catch (Exception e) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage(e.getMessage());
            return result;
        }
        return Result.success();
    }

    //    @PutMapping("/priority/move-down/{id}")
    public Result moveDown(@PathVariable("id") int id) {
        try {
            lifeInfoManipulation.priorityMoveDown(id);
        } catch (SwapException e) {
            Result result = new Result();
            result.setCode(400);
            result.setMessage(e.getMessage());
            return result;
        }
        return Result.success();
    }


    //    @PutMapping("/priority/swap")
    public Result moveDown(@RequestParam("a") int a, @RequestParam("b") int b) {
        lifeInfoManipulation.prioritySwap(a, b);
        return Result.success();
    }

}
