package com.javatribe.direction.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javatribe.direction.bean.dto.ApiResult;
import com.javatribe.direction.bean.entity.Cooperation;
import com.javatribe.direction.service.CooperationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Cooperation)表控制层
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */

@RestController
@RequestMapping("cooperation")
public class CooperationController {

    @Autowired
    private CooperationService cooperationService;

    @PostMapping
    public ApiResult save(@RequestBody Cooperation cooperation) {
        if (cooperation.getCooperationId() != null) {
            Cooperation old = cooperationService.get(cooperation.getCooperationId());
            BeanUtils.copyProperties(cooperation, old);
            cooperationService.update(old);
        } else {
            cooperationService.insert(cooperation);
        }
        return ApiResult.success();
    }

    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable Long id) {
        cooperationService.delete(id);
        return ApiResult.success();
    }

    @GetMapping("/{id}")
    public ApiResult get(@PathVariable String id) {
        Cooperation cooperation = cooperationService.get(id);
        return ApiResult.success(cooperation);
    }

    @GetMapping("list")
    public ApiResult list(Integer page, Integer limit) {
        Page<Cooperation> rsPage = cooperationService.getPage(page, limit);
        System.out.println(rsPage);
        return ApiResult.success(rsPage);
    }


}
