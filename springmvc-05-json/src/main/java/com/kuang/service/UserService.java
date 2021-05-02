package com.kuang.service;
import com.kuang.pojo.Role;
import com.kuang.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService  extends  UserDetailsService{
    public List<UserInfo> findAllUser(int page,int size) throws  Exception;
    public void saveUser(UserInfo userInfo) throws Exception;
    public UserInfo findUserById(String id) throws Exception;
    public List<Role> findOtherRoles(String userId) throws Exception;
    public void addRoleToUser( String userId, String[] roleIds) throws Exception;
    void deleteRoleByUserId(String userId, String roleId);
    void deleteUserById(String userId) throws Exception;
    UserInfo findUserByUserName(String userName) throws Exception;
    boolean userSaveUser(UserInfo userInfo) throws Exception;
    boolean activeUser(String code) throws Exception;
    boolean userLogin(UserInfo userInfo, HttpServletRequest request) throws Exception;
    List<UserInfo> queryForUserName(String userName,int page,int size) throws Exception;
}
