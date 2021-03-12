package com.javatribe.cooperation.controller;

import com.javatribe.cooperation.bean.bo.CooperationBO;
import com.javatribe.cooperation.bean.dto.ApiResult;
import com.javatribe.cooperation.bean.dto.ApiResults;
import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.service.CooperationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Cooperation)表控制层
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

    @PostMapping("insert")
    public ApiResult insert(@RequestBody CooperationBO cooperationBO) {
        cooperationBO.setId(null);
        Cooperation cooperation = new Cooperation();
        BeanUtils.copyProperties(cooperationBO, cooperation);
        //todo
        cooperation.setCreateBy(1);
        cooperation.setUpdateBy(1);
        cooperationService.insert(cooperation);
        return ApiResults.success();
    }

    @PostMapping("update")
    public ApiResult update(@RequestBody CooperationBO cooperationBO) {
        if (cooperationBO.getId() == null) {
            return ApiResults.badRequest("要修改的数据id不存在");
        } else {
            Cooperation cooperation = cooperationService.get(cooperationBO.getId());
            if (cooperation == null) {
                return ApiResults.badRequest("id所在数据不存在");
            }
            BeanUtils.copyProperties(cooperation, cooperationBO);
            //todo
            cooperation.setUpdateBy(1);
            cooperationService.update(cooperation);
        }
        return ApiResults.success();
    }


    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Integer id) {
        cooperationService.delete(id);
        return ApiResults.success();
    }

    @GetMapping("/{id}")
    public ApiResult get(@PathVariable Integer id) {
        return ApiResults.success(cooperationService.get(id));
    }

    @GetMapping("getAll")
    public ApiResult getAll(@Param("type") Integer type) {
        return ApiResults.success(cooperationService.getAll(type));
    }


    @GetMapping("page")
    public ApiResult page(@Param("type") Integer type, @Param("page") Integer page, @Param("size") Integer size) {
        return ApiResults.success(cooperationService.page(type, page, size));
    }

    @GetMapping("getCounts")
    public ApiResult getCounts() {
        return ApiResults.success(cooperationService.getCounts());
    }
}
