package com.shiro.auth.mapper;

import com.shiro.auth.pojo.Permissions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionsMapper {

    /**
     * 根据权限编号查询权限
     * @param roleid
     * @return
     */
    List<Permissions> getInfoByRoleId(Integer roleid);
}