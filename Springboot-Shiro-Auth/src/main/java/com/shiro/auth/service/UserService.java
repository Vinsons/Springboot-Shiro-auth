package com.shiro.auth.service;

import com.shiro.auth.pojo.User;

/**
 * @ClassName UserService
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-25 15:57
 * @Version 1.0
 **/
public interface UserService {

    User login(String username);
}
