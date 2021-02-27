package com.javatribe.direction.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javatribe.direction.bean.dto.ApiResult;
import com.javatribe.direction.bean.entity.Direction;
import com.javatribe.direction.service.DirectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * (Direction)表控制层
 *
 * @author LCW
 * @since 2021-02-27 19:03:09
 */

@RestController
@RequestMapping("direction")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @PostMapping
    public ApiResult save(@RequestBody Direction direction) {
        if (direction.getDirectionId() != null) {
            Direction old = directionService.get(direction.getDirectionId());
            BeanUtils.copyProperties(direction, old);
            directionService.update(old);
        } else {
            directionService.insert(direction);
        }
        return ApiResult.success();
    }

    @DeleteMapping("/{id}")
    public ApiResult remove(@PathVariable String id) {
        directionService.delete(id);
        return ApiResult.success();
    }

    @GetMapping("/{id}")
    public ApiResult get( @PathVariable String id) {
        Direction direction = directionService.get(id);
        return ApiResult.success(direction);
    }

    @GetMapping("list")
    public ApiResult list(Integer page, Integer limit) {
        Page<Direction> rsPage = directionService.getPage(page, limit);
        return ApiResult.success(rsPage);
    }

}
