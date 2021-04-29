package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.kuang.pojo.Role;
import com.kuang.pojo.UserInfo;
import com.kuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户相关Controler
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 查找用户
     * @param page
     * @param size
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/findAll.do")
    public String findAllUser(@RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "5")int size, Model model) throws Exception {
        List<UserInfo> allUser = userService.findAllUser(page,size);
        PageInfo pageInfo = new PageInfo(allUser);
        model.addAttribute("userList",pageInfo);
        return "user-list";
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/save.do")
    public String createUser(UserInfo userInfo) throws Exception {
        userService.saveUser(userInfo);
        System.out.println(userInfo);
        return  "redirect:findAll.do";
    }
//    @PostMapping("/save.do")
//    public String createUser(UserInfo userInfo, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
//       String uploadFileName= file.getOriginalFilename();
//       if("".equals( uploadFileName))
//       {
//           return  "redirect:findAll.do";
//       }
//        String path = request.getServletContext().getRealPath("/upload");
//        File realPath = new File(path);
//        if (!realPath.exists()){
//            realPath.mkdir();
//        }
//        InputStream is = file.getInputStream(); //文件输入流
//        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流
//
//        //读取写出
//        int len=0;
//        byte[] buffer = new byte[1024];
//        while ((len=is.read(buffer))!=-1){
//            os.write(buffer,0,len);
//            os.flush();
//        }
//        os.close();
//        is.close();
//        userInfo.setProfilePicture("/upload/"+uploadFileName);
//        userService.saveUser(userInfo);
//        System.out.println(userInfo);
//        return  "redirect:findAll.do";
//    }

    /**
     * 查询单个用户详情
     */
    @GetMapping("/findById.do")
    public String findUserById(String id,Model model) throws Exception {
        UserInfo userById = userService.findUserById(id);
        System.out.println(userById.getProfilePicture());
        model.addAttribute("user",userById);
        return "user-show";
    }

    /**
     * 查询用户 以及用户可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String id,Model model) throws Exception
    {
        //根据用户id查询用户
        UserInfo userInfo = userService.findUserById(id);
        List<Role> otherRoles = userService.findOtherRoles(id);
        model.addAttribute("user",userInfo);
        model.addAttribute("roleList",otherRoles);
        return  "user-role-add";
    }

    /**
     * 给用户添加角色
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Model model,@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds) throws Exception {
        System.out.println(userId);
        userService.addRoleToUser(userId,roleIds);
        return  "redirect:findAll.do";
    }
    @ResponseBody
    @RequestMapping("relatedRole.do")
    public String relatedRole(String[] roleIds,String userId) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return  "ok";
    }

    @ResponseBody
    @RequestMapping("/deleteRoleByUserId.do")
    public String deleteRoleByUserId(String userId,String roleId) throws Exception
    {
        userService.deleteRoleByUserId(userId,roleId);
        return  "ok";
    }

    @ResponseBody
    @RequestMapping("/deleteUserById.do")
    public String deleteUserById(@RequestParam(name = "userId",required = true)String userId) throws Exception
    {
        userService.deleteUserById(userId);
        return "ok";
    }


    @PostMapping("/user_save.do")
    @ResponseBody
    public String saveUser(UserInfo userInfo,HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String codeServce = (String)session.getAttribute("CHECKCODE_SERVER");

        String codeUser = request.getParameter("checkCode");
        if (!codeServce.toUpperCase().equals(codeUser.toUpperCase()))
        {
            // 如果验证码不相等  都转换成大写
            return "not_ok";
        }
        System.out.println("验证码毛病铁汁");
        boolean flag = userService.userSaveUser(userInfo);
        System.out.println(flag);

        if (flag==false)
        {
            // 表示没有被成功保存 可能是出于多种原因
            return "not_ok";
        }
        return  "ok";
    }

    @RequestMapping("/activeUser")
    public String activeUser(@RequestParam("activeCode")String activeCode) throws Exception
    {   String msg="";
        if (activeCode!=null||activeCode.equals(""))
        {
            // 如果激活码为空
            msg="激活失败，请联系管理员";
        }
        boolean flag = userService.activeUser(activeCode);
        if (flag)
        {
            // 激活成功
            return "user_login"; // 跳转
        }
        return  null;
    }


    @ResponseBody
    @PostMapping("/userLogin")
    public String userLogin(UserInfo userInfo,HttpServletRequest request) throws Exception
    {
        Map<String,Object> resp = new HashMap<String,Object>();

        HttpSession session = request.getSession();
        String codeServce = (String)session.getAttribute("CHECKCODE_SERVER");
        String codeUser = request.getParameter("checkCode");
        ObjectMapper mapper = new ObjectMapper();
        if (!codeServce.toUpperCase().equals(codeUser.toUpperCase()))
        {
            resp.put("flag",false);
            resp.put("msg","验证码错误");
            String ans = mapper.writeValueAsString(resp);
//            return  resp.toString();
            return  ans;
        }
        if (userService.userLogin(userInfo,request)==true)
        {
            resp.put("flag",true);
            resp.put("msg","ok");
        }
        else
        {
            resp.put("flag",false);
            resp.put("msg","用户名或密码错误");
        }
        return mapper.writeValueAsString(resp);
    }
    @ResponseBody
    @GetMapping("/findUser")
    public String findUSer(HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println(username);
        return  mapper.writeValueAsString(username);
    }
    @GetMapping("/userLogout")
    public String userLogout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return "user_login";
    }
}
