package com.kuang.dao;

import com.kuang.pojo.Permission;

import java.util.List;

/**
 * 权限相关查询
 */
public interface PermissionMapper {
    public List<Permission> findPermissionByRoleId(int id) throws Exception;
    public List<Permission> findAllPermission() throws Exception;
    public void savePermission(Permission permission) throws Exception;
    public void deleteById(String id) throws Exception;
    public void deleteFromRole_permission(String id) throws Exception;
}
