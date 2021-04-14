package com.javatribe.introduction.controller;


import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.introduction.entity.Postgraduate;
import com.javatribe.introduction.service.PostgraduateService;
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
@RequestMapping("/introduction/postgraduate")
public class PostgraduateController {

    @Autowired
    private PostgraduateService postgraduateService;

    @GetMapping("findAll")
    @TokenFreeAnnotation
    public Result findAll() {
        List<Postgraduate> postgraduates = postgraduateService.findAll();
        HashMap<String, Object> res      = new HashMap<>();
        res.put("postgraduates", postgraduates);
        return Result.success(res);
    }

    @PostMapping("addPostGraduate")
    @AdminAuthentication
    public Result addPostGraduate(@RequestBody Postgraduate postgraduate) {
        if (postgraduateService.addPostGraduate(postgraduate) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @PostMapping("updatePostGraduate")
    @AdminAuthentication
    public Result updatePostGraduate(@RequestBody Postgraduate postgraduate) {
        if (postgraduateService.updatePostGraduate(postgraduate) == 1) {
            return Result.success();
        }
        return Result.fail();
    }

    @DeleteMapping("deletePostGraduate")
    @AdminAuthentication
    public Result deletePostGraduate(@RequestParam("id") Integer id) {
        if (postgraduateService.deletePostGraduate(id) == 1) {
            return Result.success();
        }
        return Result.fail();
    }
}

