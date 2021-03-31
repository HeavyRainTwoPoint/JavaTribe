package com.javatribe.apicommon.service.impl;

import com.javatribe.apicommon.core.constant.GDUFHost;
import com.javatribe.apicommon.dao.UserMapper;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apicommon.dto.UserDTO;
import com.javatribe.apicommon.entity.User;
import com.javatribe.apicommon.entity.UserQTO;
import com.javatribe.apicommon.interceptor.role.UserType;
import com.javatribe.apicommon.service.UserService;
import com.javatribe.apicommon.util.HttpUtil;
import com.javatribe.apicommon.util.JwtUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
        try {
            // 如果不存在，就存入数据库
            UserQTO userQTO = new UserQTO();
            userQTO.createCriteria().andAccountEqualTo(user.getAccount()).andDeleteMarkEqualTo(0);
            if (userMapper.countByExample(userQTO) <= 0) { // 不存在
                user.setPassword(Base64.encodeBase64String(user.getPassword().getBytes()));
                user.setRealName(userDTO.getUserRealName());
                userMapper.insertSelective(user);
                // 生成token
                Map<String,String> map = new HashMap<>();
                map.put("STU_NUMBER",user.getAccount()); //  在token里放数据
                userDTO.setToken(JwtUtil.getUserToken(map));
                userDTO.setStatus(1);
                userDTO.setSchoolNumber(user.getAccount());
                return new Response<>(userDTO);
            } else { // 已经存在了
                // 生成token
                Map<String,String> map = new HashMap<>();
                map.put("STU_NUMBER",user.getAccount()); //  在token里放数据
                // 查看用户类型
                UserQTO qto = new UserQTO();
                qto.createCriteria().andAccountEqualTo(user.getAccount());
                userDTO.setSchoolNumber(user.getAccount());
                List<User> users = userMapper.selectByExample(qto);

                if (!users.isEmpty()) {
                    if (users.get(0).getUserType() == UserType.USER.getTypeCode()) {
                        userDTO.setToken(JwtUtil.getUserToken(map));
                    } else if (users.get(0).getUserType() == UserType.ADMIN.getTypeCode()) {
                        userDTO.setToken(JwtUtil.getAdminToken(map));
                    } else if (users.get(0).getUserType() == UserType.SUPER.getTypeCode()) {
                        userDTO.setToken(JwtUtil.getSuperToken(map));
                    }
                    userDTO.setStatus(1);
                } else {
                    userDTO.setStatus(-1); // 未登录
                }

            }

            return new Response<>(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
      return null;
    }

    @Override
    public Response<Object> addOrUpdateAdmin(User user) {
        UserQTO qto = new UserQTO();
        qto.createCriteria().andAccountEqualTo(user.getAccount());
        if (userMapper.countByExample(qto) > 0) {
            if (userMapper.updateByExampleSelective(user,qto) > 0) {
                return Response.success(ResponseStatus.SUCCESS);
            }
        }
        return Response.fail(ResponseStatus.COMMAND_ERROR);
    }

    @Override
    public Response<Integer> queryUserType(String account) {
        UserQTO qto = new UserQTO();
        qto.createCriteria().andAccountEqualTo(account);
        List<User> users = userMapper.selectByExample(qto);
        if (users.size() > 0) {
            return Response.success(users.get(0).getUserType());
        }
        return Response.fail(ResponseStatus.COMMAND_ERROR);
    }

    @Override
    public Response<List<User>> queryList() {
        UserQTO qto = new UserQTO();
        qto.createCriteria().andDeleteMarkEqualTo(0);
        return Response.success(userMapper.selectByExample(qto));
    }
}
