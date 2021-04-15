package com.javatribe.introduction.controller;


import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.introduction.entity.History;
import com.javatribe.introduction.entity.Management;
import com.javatribe.introduction.service.HistoryService;
import com.javatribe.introduction.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzp
 * @since 2021-02-12
 */
@RestController
@RequestMapping("/introduction/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("findAll")
    @TokenFreeAnnotation
    public Result findAll() {
        List<History>           histories = historyService.findAll();
        HashMap<String, Object> res       = new HashMap<>();
        res.put("histories", histories);
        return Result.success(res);
    }

    @PostMapping("addHistory")
    @AdminAuthentication
    public Result addHistory(@RequestBody History historie) {
        if (historyService.addHistory(historie) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @DeleteMapping("deleteHistory")
    @AdminAuthentication
    public Result deleteHistory(@RequestParam("id") Integer id) {
        if (historyService.deleteHistory(id) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("updateHistory")
    @AdminAuthentication
    public Result updateHistory(@RequestBody History history) {
        if (historyService.updateHistory(history) == 1) {
            return Result.success();
        }
        return Result.fail();
    }
}

