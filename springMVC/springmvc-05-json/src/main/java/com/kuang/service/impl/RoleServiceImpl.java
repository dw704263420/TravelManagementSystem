package com.kuang.service.impl;

import com.kuang.dao.RoleMapper;
import com.kuang.pojo.Permission;
import com.kuang.pojo.Role;
import com.kuang.service.RoleService;


import javax.annotation.security.RolesAllowed;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }


    @Override
    public List<Role> findAllRole() throws Exception {
        return roleMapper.findAllRole();
    }

    @Override
    public void saveRole(Role role) throws Exception {
        roleMapper.saveRole(role);
    }

    @Override
    public List<Role> findRoleById(int id) throws Exception {
        return roleMapper.findRoleById(id);
    }

    @Override
    public void deleteRoleById(int id) throws Exception {
        roleMapper.deleteFromUser_RoleByRoleId(id);
        roleMapper.deleteFromRole_PermissionByRoleId(id);
        roleMapper.deleteRoleById(id);
    }


    @Override
    public Role findARoleById(int roleId) {
        return roleMapper.findARoleById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(int roleId) {
        return roleMapper.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] perIds) {
        for (int perId : perIds) {
            roleMapper.addPermissionToRole(roleId,perId);
        }
    }

    @Override
    public void deletePerByRole(int roleId, int perId) throws Exception {
        roleMapper.deletePerByRole(roleId,perId);
    }


}
