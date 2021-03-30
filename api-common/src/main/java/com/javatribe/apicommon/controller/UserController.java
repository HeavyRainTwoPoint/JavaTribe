package com.javatribe.apicommon.controller;

import cn.hutool.core.util.ObjectUtil;
import com.javatribe.apicommon.annotation.SuperAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apicommon.dto.UserDTO;
import com.javatribe.apicommon.entity.User;
import com.javatribe.apicommon.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/16 21:07
 * @description  用户登录相关
 */
@RestController
@RequestMapping("/javatribe/common/user")
public class UserController {

    @Resource
    private UserService userService;

    @TokenFreeAnnotation
    @PostMapping("/login")
    public Response<UserDTO> login(@RequestBody(required = false) User user) {
        if (ObjectUtil.isNull(user))
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        return userService.login(user);
    }


    @SuperAuthentication
    @PostMapping("/update")
    public Response<Object> addOrUpdateAdmin(@RequestBody(required = false) User user) {
        if (ObjectUtil.isNull(user))
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        return userService.addOrUpdateAdmin(user);
    }

    @SuperAuthentication
    @GetMapping("/user_type")
    public Response<Integer> queryUserType(@RequestParam("account") String account) {
        return userService.queryUserType(account);
    }

    @SuperAuthentication
    @GetMapping("/admin/list")
    public Response<List<User>> queryList() {
        return userService.queryList();
    }
}
