package com.shiro.auth.pojo;

import lombok.Data;

import java.util.Set;

/**
 * @ClassName User
 * @Description
 * @Author 黄文聪
 * @Date 2019-11-25 15:34
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 用户权限
     */
    private Set<Permissions> permissions;

}