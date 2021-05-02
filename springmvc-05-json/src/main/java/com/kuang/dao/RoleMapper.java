package com.kuang.dao;

import com.kuang.pojo.Permission;
import com.kuang.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色相关查询
 */
public interface RoleMapper {
    // 根据用于ID查询对应的角色
    public List<Role> findRoleByUserId(@Param("UserId") String userId) throws Exception;

    public List<Role> findAllRole() throws Exception;

    public void saveRole(Role role) throws Exception;

    public List<Role> findRoleById(int id) throws Exception;
    public void deleteFromUser_RoleByRoleId(int id) throws Exception;  //删除users_role表中的记录，并非删除user

    public void deleteFromRole_PermissionByRoleId(int id) throws Exception; // 删除role_permission中的记录，并非删除permission
    public void deleteRoleById(int id) throws Exception; // 删除role本身

    public Role findARoleById(int roleId);
    public List<Permission> findOtherPermission(int roleId);
    public void addPermissionToRole(@Param("roleId") int roleId,@Param("perId") int perId);

    void deletePerByRole(@Param("roleId") int roleId,@Param("perId") int perId) throws Exception;
}
