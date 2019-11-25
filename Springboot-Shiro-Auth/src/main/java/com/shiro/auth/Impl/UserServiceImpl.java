package com.shiro.auth.Impl;

import com.shiro.auth.mapper.PermissionsMapper;
import com.shiro.auth.mapper.UserMapper;
import com.shiro.auth.pojo.Permissions;
import com.shiro.auth.pojo.User;
import com.shiro.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-25 15:57
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionsMapper permissionsMapper;

    @Override
    public User login(String username) {
        return getInfoByName(username);
    }

    /**
     * 通过姓名获取用户信息 并将权限赋予
     * @param username
     * @return
     */
    public User getInfoByName(String username) {
        Map<String ,User> map = new HashMap<>();
        User info = userMapper.getUserInfoByName(username);
        if (null!=info&&null!=info.getRole()){
            List<Permissions> permissionsList = permissionsMapper.getInfoByRoleId(info.getRole());
            Set<Permissions> permissionsSet = new HashSet<>();
            permissionsSet.addAll(permissionsList);
            info.setPermissions(permissionsSet);
            map.put(info.getUsername(),info);
        }
        return map.get(username);
    }

}
