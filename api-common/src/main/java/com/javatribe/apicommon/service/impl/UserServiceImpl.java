package com.javatribe.apicommon.service.impl;

import com.javatribe.apicommon.core.constant.GDUFHost;
import com.javatribe.apicommon.dao.UserMapper;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.UserDTO;
import com.javatribe.apicommon.entity.User;
import com.javatribe.apicommon.entity.UserQTO;
import com.javatribe.apicommon.service.UserService;
import com.javatribe.apicommon.util.HttpUtil;
import com.javatribe.apicommon.util.JwtUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/16 21:26
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Transactional
    @Override
    public Response<UserDTO> login(User user) {
        UserDTO userDTO = HttpUtil.doGDUFGet(GDUFHost.HOST.replace(GDUFHost.PARAM1, user.getAccount()).replace(GDUFHost.PARAM2, user.getPassword()));
        if (userDTO == null || userDTO.getToken().equals("-1")) {
            userDTO.setStatus(-1); // 未登录
            return new Response<>(userDTO);
        }
        // 如果不存在，就存入数据库
        UserQTO userQTO = new UserQTO();
        userQTO.createCriteria().andAccountEqualTo(user.getAccount()).andDeleteMarkEqualTo(0);
        if (userMapper.countByExample(userQTO) < 0) { // 不存在
            user.setPassword(Base64.encodeBase64String(user.getPassword().getBytes()));
            user.setRealName(userDTO.getUserRealName());
            userMapper.insertSelective(user);
            // 生成token
            Map<String,String> map = new HashMap<>();
            map.put("STU_NUMBER",user.getAccount()); //  在token里放数据
            userDTO.setToken(JwtUtil.getUserToken(map));
            userDTO.setStatus(1);
        } else { // 已经存在了
            // 生成token
            Map<String,String> map = new HashMap<>();
            map.put("STU_NUMBER",user.getAccount()); //  在token里放数据
            userDTO.setToken(JwtUtil.getUserToken(map));
            userDTO.setStatus(1);
        }
        return new Response<>(userDTO);
    }
}
