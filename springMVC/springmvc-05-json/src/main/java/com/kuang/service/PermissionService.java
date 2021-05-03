package com.kuang.service;

import com.kuang.pojo.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAllPermission() throws Exception;
    public void savePermission(Permission permission) throws Exception;
    public void deleteById(String id)throws Exception;

}
