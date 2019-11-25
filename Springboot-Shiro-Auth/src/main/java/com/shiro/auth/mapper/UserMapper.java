package com.shiro.auth.mapper;

import com.shiro.auth.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


    /**
     * 根据姓名查询用户信息
     * @param username
     * @return
     */
    User getUserInfoByName(String username);


}