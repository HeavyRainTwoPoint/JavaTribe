package com.javatribe.apishare.controller.admin;

import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.SuperAuthentication;
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.po.Tag;
import com.javatribe.apishare.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/15 12:19
 */
@RestController
@RequestMapping("/share/admin")
public class AdminTagController {
    @Autowired
    private TagService tagService;

    /**
     * 修改tag的名字
     *
     * @param tag – 需要传递tagName，tagId两个值
     * @return
     */
    @AdminAuthentication
    @SuperAuthentication
    @PostMapping("/updateTagName")
    public Result updateTagName(@RequestBody Tag tag) {
        int result = tagService.updateTag(tag);
        return result > 0 ? new Result(ApiInfo.OK.getCode(), "修改成功！", null)
                : new Result(ApiInfo.BASIC_ERROR.getCode(), "修改失败！请检查提交的数据！", null);
    }

    /**
     * 删除标签
     * @param map 包含待删除的标签的tagId
     * @return
     */
    @AdminAuthentication
    @PostMapping("/deleteTag")
    public Result deleteTag(@RequestBody Map<String, Integer> map) {
        int result = tagService.deleteTagById(map.get("tagId"));
        return result == 1 ? new Result(ApiInfo.OK.getCode(), "已删除标签!", null)
                : new Result(ApiInfo.BASIC_ERROR.getCode(), "删除失败！该标签下有文章存在，不能被删除！", null);
    }

    /**
     * 添加标签
     * 成功之后把新标签数据返回去
     * @param tag
     * @return
     */
    @AdminAuthentication
    @PutMapping("/addTag")
    public Result addTag(@RequestBody Tag tag) {
        int result = tagService.insertTag(tag);
        Result r = new Result();
        if (result == -1) {
            r.setCode(ApiInfo.BAD_REQUEST.getCode());
            r.setMessage("该标签已存在！不允许重复插入！");
        } else if (result > 1) {
            r.setMessage("插入成功！");
            r.setCode(ApiInfo.OK.getCode());
            r.setData(tag);
        } else {
            r.setCode(ApiInfo.BASIC_ERROR.getCode());
            r.setMessage("插入失败！请刷新后重试！");
        }
        return r;
    }

}
