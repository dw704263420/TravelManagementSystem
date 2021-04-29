package com.kuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.UserMapper;
import com.kuang.pojo.Role;
import com.kuang.pojo.UserInfo;
import com.kuang.service.UserService;

import com.kuang.utils.MailUtils;
import com.kuang.utils.MailUtils2;
import com.kuang.utils.MailUtils3;
import com.kuang.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MailUtils3 mailUtils3;

    private UserMapper userMapper;
    // 下面这个是springs ecurity中的密码加密bean，直接用就可以进行加密，在saveUser方法中有用到


    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo= userMapper.findByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 将自己的用户对象封装成UserDetails        这个{noop}是必要的密码前缀，不过如果使用加密，就可以不用该前缀  // 指定该角色的权限是否有效                                                                                 指定用户的权限集合
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles())); //权限集合，第一次尝试先设置为null,
        // 在session中设置头像图片路径

        return user; // User 类实现了UserDetails
    }

    // 作用是返回一个List集合，里面装入的是权限、橘色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles)
    {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //SimpleGrantedAuthority 的构造方法，传入一个字符串，该字符串是权限等级,表示该方法作用的用户拥有该权限集合（这里只写了一个，但是可以不止add一个）
        for (Role role : roles) {                                             // mysql查询过来的东西可能是小写，但是我们需要规定为大写才行
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase()));
        }

        // 但是角色赋值肯定不是我们手动赋值的，得去数据库中获取
        return list;
    }

    @Override
    public List<UserInfo> findAllUser(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return userMapper.findAllUser();
    }

    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        // 这里进行了修改后加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userMapper.saveUser(userInfo);
    }

    @Override
    public UserInfo findUserById(String id) throws Exception {
        return  userMapper.findByUserId(id);
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userMapper.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            System.out.println("impl"+roleId);
        }
        for (String roleId : roleIds) {

            userMapper.addRoleToUser(userId,roleId);

        }
    }

    @Override
    public void deleteRoleByUserId(String userId, String roleId) {
        userMapper.deleteRoleByUserId(userId,roleId);
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userMapper.deleteUserById(userId);
    }

    @Override
    public UserInfo findUserByUserName(String userName) throws Exception {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public boolean userSaveUser(UserInfo userInfo) throws Exception {

        UserInfo user= userMapper.findUserByUserName(userInfo.getUsername()); // 如果查询到有重复的用户名
        if (user!=null)
        {
            return  false;
        }
        // 设置激活码,利用UUID类
        userInfo.setActiveCode(UuidUtil.getUuid());
        userInfo.setStatus(0);  // 0代表未激活
        String activeCode = userInfo.getActiveCode();
        String content="<a href='http://localhost:8080/springmvc_05_json_war_exploded/user//user_save.do?activeCode="+activeCode+"'>点击激活【黑马旅游网】</a>";
        String email = userInfo.getEmail();
        String title = "亲子旅游网用户激活邮件";
        mailUtils3.send(email,content,title);
        userMapper.saveUser(userInfo);

        return true;
    }

    @Override
    public boolean activeUser(String code) throws Exception {
        // 根据激活码查询用户，看看是否有这个用户，然后将激活状态改变
        UserInfo userByaAtiveCode = userMapper.findUserByaAtiveCode(code);
        if (userByaAtiveCode!=null)
        {
            userMapper.updateUserStatus(userByaAtiveCode.getId());
            return true;
        }


        return false;
    }

    @Override
    public boolean userLogin(UserInfo userInfo,HttpServletRequest request) throws Exception {
        String uname = userInfo.getUsername();
        String pwd = userInfo.getPassword();
        UserInfo byUsername = userMapper.findByUsername(uname);
        if (byUsername == null)
        {
            return false;
        }
        boolean matches = bCryptPasswordEncoder.matches(pwd, byUsername.getPassword());
        if (matches == true)
        {
            HttpSession session = request.getSession();
            session.setAttribute("username",byUsername.getUsername());
            session.setAttribute("uid",byUsername.getId());
            return  true;
        }else
        {
            return  false;
        }
    }

}
