package com.shiro.auth.pojo;

import lombok.Data;

/**
 * @ClassName Permissions
 * @Description 
 * @Author 黄文聪
 * @Date  2019-11-25 15:55
 * @Version 1.0
 **/
@Data
public class Permissions {
    private Integer id;

    private String permissionsname;

    private Integer roleid;

}