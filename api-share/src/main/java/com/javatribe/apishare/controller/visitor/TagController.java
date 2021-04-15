package com.javatribe.apishare.controller.visitor;

import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/14 21:12
 */

@RestController
@RequestMapping("/share/visit")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 获取所有的一级标签
     *
     * @return
     */
    @TokenFreeAnnotation
    @GetMapping("/getAllParentTags")
    public Result getAllParentTags() {
        return new Result(ApiInfo.OK.getCode(), "OK", tagService.getAllParentTags());
    }

    /**
     * 根据一级标签的id获取所有的二级标签
     *
     * @param tagParent
     * @return
     */
    @TokenFreeAnnotation
    @GetMapping("/getSonTagByParent")
    public Result getSonTagByParent(@PathParam("tagParent") int tagParent) {
        return new Result(ApiInfo.OK.getCode(), "OK", tagService.getSonTags(tagParent));
    }


}
