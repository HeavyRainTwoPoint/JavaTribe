package com.javatribe.cooperation.controller;

import com.javatribe.cooperation.bean.bo.CooperationBO;
import com.javatribe.cooperation.bean.dto.ApiResult;
import com.javatribe.cooperation.bean.dto.ApiResults;
import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.bean.enums.CooperationType;
import com.javatribe.cooperation.service.CooperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 合作交流控制层
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Slf4j
@RestController
@RequestMapping("cooperation")
public class CooperationController {

    @Resource
    private CooperationService cooperationService;

    /**
     * 插入合作交流数据
     */
    @PostMapping("insert")
    public ApiResult insert(@RequestBody CooperationBO cooperationBO) {
        if (!checkCooperationType(cooperationBO)) {
            return ApiResults.badRequest("类型有误");
        }
        if (!checkCooperationItems(cooperationBO)) {
            return ApiResults.badRequest("交流事项不能为空");
        }
        cooperationBO.setId(null);
        Cooperation cooperation = new Cooperation();
        BeanUtils.copyProperties(cooperationBO, cooperation);
        //todo  添加操作人信息
        cooperation.setCreateBy(1);
        cooperation.setUpdateBy(1);
        cooperationService.insert(cooperation);
        return ApiResults.success();
    }

    /**
     * 更新合作交流数据
     */
    @PostMapping("update")
    public ApiResult update(@RequestBody CooperationBO cooperationBO) {
        if (cooperationBO.getId() == null) {
            return ApiResults.badRequest("要修改的数据id不存在");
        } else {
            if (!checkCooperationType(cooperationBO)) {
                return ApiResults.badRequest("类型有误");
            }
            if (!checkCooperationItems(cooperationBO)) {
                return ApiResults.badRequest("交流事项不能为空");
            }
            Cooperation cooperation = cooperationService.get(cooperationBO.getId());
            if (cooperation == null) {
                return ApiResults.badRequest("id所在数据不存在");
            }
            BeanUtils.copyProperties(cooperation, cooperationBO);
            //todo  添加操作人信息
            cooperation.setUpdateBy(1);
            cooperationService.update(cooperation);
        }
        return ApiResults.success();
    }

    private boolean checkCooperationItems(CooperationBO cooperationBO) {
        if (cooperationBO.getType() == CooperationType.InCooperation.getType()) {
            return cooperationBO.getItems() != null && !cooperationBO.getItems().equals("");
        }
        return false;
    }

    private boolean checkCooperationType(CooperationBO cooperationBO) {
        return cooperationBO.getType() == CooperationType.InCooperation.getType()
                || cooperationBO.getType() == CooperationType.OutCooperation.getType();
    }


    /**
     * 删除指定id的数据
     */
    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Integer id) {
        cooperationService.delete(id);
        return ApiResults.success();
    }

    /**
     * 获取指定id的数据
     */
    @GetMapping("/{id}")
    public ApiResult get(@PathVariable Integer id) {
        return ApiResults.success(cooperationService.get(id));
    }

    /**
     * 获取全部数据
     */
    @GetMapping("getAll")
    public ApiResult getAll(@RequestParam("type") Integer type) {
        return ApiResults.success(cooperationService.getAll(type));
    }

    /**
     * 按类型分页数据
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam("type") Integer type, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return ApiResults.success(cooperationService.page(type, page, size));
    }

    /**
     * 获取指定类型的全部数据个数
     */
    @GetMapping("getCounts")
    public ApiResult getCounts(@RequestParam("type") Integer type) {
        return ApiResults.success(cooperationService.getCounts(type));
    }

    /**
     * 获取全部数据个数
     */
    @GetMapping("getAllCounts")
    public ApiResult getAllCounts() {
        return ApiResults.success(cooperationService.getAllCounts());
    }


}
