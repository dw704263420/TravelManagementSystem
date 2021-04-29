package com.kuang.service.impl;

import com.kuang.dao.PermissionMapper;
import com.kuang.pojo.Permission;
import com.kuang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class PermissionServiceImpl  implements PermissionService {


    private PermissionMapper permissionMapper;

    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> findAllPermission() throws Exception {
        return permissionMapper.findAllPermission();
    }

    @Override
    public void savePermission(Permission permission) throws Exception {
        permissionMapper.savePermission(permission);
    }

    @Override
    public void deleteById(String id) throws Exception {
        permissionMapper.deleteById(id);
        permissionMapper.deleteFromRole_permission(id);
    }
}
