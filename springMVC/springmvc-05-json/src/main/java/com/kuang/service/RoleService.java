package com.kuang.service;

import com.kuang.pojo.Permission;
import com.kuang.pojo.Role;

import java.util.List;

public interface  RoleService {
    public List<Role> findAllRole() throws Exception;

    void saveRole(Role role) throws Exception;

    List<Role> findRoleById(int id) throws Exception;
    public void deleteRoleById(int id) throws Exception;

    public Role findARoleById(int roleId);
    public List<Permission> findOtherPermission(int roleId);
    public void addPermissionToRole(int roleId,int[] perIds);

    void deletePerByRole(int roleId, int perId) throws Exception;
}
