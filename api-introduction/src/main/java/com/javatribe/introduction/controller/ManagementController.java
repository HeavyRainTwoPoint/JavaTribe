package com.javatribe.introduction.controller;


import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.introduction.entity.Management;
import com.javatribe.introduction.service.ManagementService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatribe.apicommon.dto.Result;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzp
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/introduction/management")
@CrossOrigin
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @GetMapping("findAll")
    @TokenFreeAnnotation
    public Result findAll() {
        List<Management> managements = managementService.findAll();
        HashMap<String, Object> res = new HashMap<>();
        res.put("managements", managements);
        return Result.success(res);
    }

    @GetMapping("findById")
    @AdminAuthentication
    public Result findById(@RequestParam("id") String id) {
        Management management = managementService.findById(id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("management", management);
        return Result.success(res);
    }

    @GetMapping("sessionsLeader")
    @AdminAuthentication
    public Result sessionsLeader() {
        List<Management> leaders = managementService.findLeader();
        HashMap<String, Object> res = new HashMap<>();
        res.put("leaders", leaders);
        return Result.success(res);
    }

    @GetMapping("presentManager")
    @AdminAuthentication
    public Result presentManager() {
        List<Management> presents = managementService.findPresent();
        HashMap<String, Object> res = new HashMap<>();
        res.put("presents", presents);
        return Result.success(res);
    }

    @PostMapping("addManager")
    @AdminAuthentication
    public Result addManager(@RequestBody Management manage) {
        if (managementService.addManager(manage) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @DeleteMapping("deleteManager")
    @AdminAuthentication
    public Result deleteManager(@RequestParam("id") Integer id) {
        if (managementService.deleteManager(id) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("updateManager")
    @AdminAuthentication
    public Result updateManager(@RequestBody Management manage) {
        if (managementService.updateManager(manage) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

}

