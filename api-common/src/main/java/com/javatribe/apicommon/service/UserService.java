package com.javatribe.apicommon.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.UserDTO;
import com.javatribe.apicommon.entity.User;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/16 21:25
 * @description
 */
public interface UserService {
    Response<UserDTO> login(User user);
}
