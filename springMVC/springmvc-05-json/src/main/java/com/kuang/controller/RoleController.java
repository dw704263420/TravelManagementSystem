package com.kuang.controller;

import com.kuang.pojo.Permission;
import com.kuang.pojo.Role;
import com.kuang.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * 角色相关Controler-需要超级管理员
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    @Qualifier("RoleServiceImpl")
    private RoleService roleService;

    /**
     * 超级管理员-查看所有角色
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @RequestMapping("/findAll.do")
    public String findAllRole(Model model) throws Exception {
        List<Role> allUser;
        allUser = roleService.findAllRole();
        model.addAttribute("roleList",allUser);
        return "role-list";
    }

    /**
     * 超级管理员-增加角色
     * @param role
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @RequestMapping("/save.do")
    public String savcRole(Role role) throws Exception {
        roleService.saveRole(role);
        return "redirect:findAll.do";
    }

    /**
     * 超级管理员-查找单个角色详情
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @RequestMapping("/findById.do")
    public String findRoleById(int id,Model model) throws Exception {
        List<Role> roleById = roleService.findRoleById(id);
        model.addAttribute("role",roleById);
        return "role-show";
    }

    /**
     * 超级管理员-删除角色
     * @param id
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @ResponseBody
    @RequestMapping("/deleteById.do")
    public String deleteRoleById(@RequestParam(name = "roleId",required = true)int id) throws Exception {
        roleService.deleteRoleById(id);
        return "ok";
    }

    /**
     * 超级管理员-查看角色对应权限
     * @param roleId
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @RequestMapping("/findRoleByIdAllPermission.do")
    public String findRoleByIdAllPermission(@RequestParam(name = "id",required = true)int roleId,Model model) throws Exception {
        //根据roleId查询role
        Role role = roleService.findARoleById(roleId);
        // 根据roleId可以查询还可以添加的权限
        List<Permission> otherPermission = roleService.findOtherPermission(roleId);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",otherPermission);
        return  "role-permission-add";
    }

    /**
     * 超级管理员-给角色添加权限-同步响应
     * @param roleId
     * @param perIds
     * @return
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) int roleId,@RequestParam(name = "perId",required = true)int[] perIds)
    {
        for (int id : perIds) {
            System.out.println(id);
        }
        roleService.addPermissionToRole(roleId,perIds);
        return "redirect:findAll.do";
    }

    /**
     * 超级管理员-给角色添加权限-异步响应
     * @param roleId
     * @param perId
     * @return
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @ResponseBody
    @RequestMapping("/relatePermissionToRole.do")
    public String relatePermissionToRole(@RequestParam(name = "roleId",required = true) int roleId,@RequestParam(name = "perId",required = true)int[] perId)
    {
        roleService.addPermissionToRole(roleId,perId);
        return "ok";
    }

    /**
     * 超级管理员-删除角色地权限
     * @param roleId
     * @param perId
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @ResponseBody
    @RequestMapping("/deletePerByRole.do")
    public String deletePerByRole(@RequestParam(name = "roleId",required = true) int roleId,@RequestParam(name = "perId",required = true)int perId) throws Exception
    {
        roleService.deletePerByRole(roleId,perId);
        return "ok";
    }
}
