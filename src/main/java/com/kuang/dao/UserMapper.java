package com.kuang.dao;

import com.kuang.pojo.Role;
import com.kuang.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 用户相关查询
 */
public interface UserMapper {
    public UserInfo findByUsername(@Param("username")String username) throws Exception;
    public List<UserInfo> findAllUser() throws Exception;
    public void saveUser(UserInfo userInfo) throws Exception;
    public UserInfo findByUserId(String id) throws Exception;
    public List<Role> findOtherRoles(String userId) throws Exception;
    // 由于有多个参数，不能直接赋值过去 需要添加Param注解
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    void deleteRoleByUserId(@Param("userId") String userId, @Param("roleId") String roleId);

    void deleteUserById(String userId) throws Exception;

    UserInfo findUserByUserName(String userName) throws Exception;
    UserInfo findUserByaAtiveCode(String activeCode) throws Exception;
    void updateUserStatus(String userId) throws Exception;
}
