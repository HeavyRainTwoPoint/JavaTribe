package com.javatribe.controller;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.po.Tag;
import com.javatribe.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/14 21:12
 */

@RestController
@RequestMapping("/share")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 获取所有的一级标签
     *
     * @return
     */
    @GetMapping("/getAllParentTags")
    public List<Tag> getAllParentTags() {
        return tagService.getAllParentTags();
    }

    /**
     * 根据一级标签的id获取所有的二级标签
     *
     * @param tagParent
     * @return
     */
    @GetMapping("/getSonTagByParent")
    public List<Tag> getSonTagByParent(@PathParam("tagParent") int tagParent) {
        return tagService.getSonTags(tagParent);
    }

    /**
     * 修改tag的名字
     *
     * @param tag – 需要传递tagName，tagId两个值
     * @return
     */
    @PostMapping("/updateTagName")
    public Result updateTagName(@RequestParam Tag tag) {
        //TODO
        int result = tagService.updateTag(tag);
        return result > 0 ? new Result(ApiInfo.OK.getCode(), "修改成功！", null) : new Result(ApiInfo.BASIC_ERROR.getCode(), "修改失败！请检查提交的数据！", null);
    }

}
