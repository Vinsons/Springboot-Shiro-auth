package com.shiro.auth.controller;

import com.shiro.auth.pojo.User;
import com.shiro.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-25 16:29
 * @Version 1.0
 **/
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public User login(@RequestParam("username") String username,@RequestParam("password") String password) throws Exception{
        User user = userService.login(username);
//        if (!password.equals(user.getPassword())){
//            return null;
//        }else {
//         return user;
//        }
        return user;
    }
}
