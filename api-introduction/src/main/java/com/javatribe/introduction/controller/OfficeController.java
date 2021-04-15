package com.javatribe.introduction.controller;


import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.introduction.entity.Office;
import com.javatribe.introduction.service.OfficeService;
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
 * @since 2021-02-28
 */
@RestController
@RequestMapping("/introduction/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping("findAll")
    @TokenFreeAnnotation
    public Result findAll() {
        List<Office> offices = officeService.findAll();
        HashMap<String, Object> res = new HashMap<>();
        res.put("offices", offices);
        return Result.success(res);
    }

    @PostMapping("addOffice")
    @AdminAuthentication
    public Result addOffice(@RequestBody Office office) {
        if (officeService.addOffice(office) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("updateOffice")
    @AdminAuthentication
    public Result updateOffice(@RequestBody Office office) {
        if (officeService.updateOffice(office) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @DeleteMapping("deleteOffice")
    @AdminAuthentication
    public Result deleteOffice(@RequestParam("id") Integer id) {
        if (officeService.deleteOffice(id) == 1) {
            return Result.success();
        }
        return Result.fail();
    }
}

