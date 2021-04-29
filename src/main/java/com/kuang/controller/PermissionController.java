package com.kuang.controller;

import com.kuang.pojo.Permission;
import com.kuang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 权限相关Controler
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {


    @Autowired
    @Qualifier("PermissionServiceImpl")
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public String findAllPermission(Model model) throws Exception {
        List<Permission> allPermission = permissionService.findAllPermission();
        System.out.println(allPermission);
        model.addAttribute("permissionList",allPermission);
        return  "permission-list";
    }
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAllPermission() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Permission> allPermission = permissionService.findAllPermission();
//        mv.addObject("permissionList",allPermission);
//        mv.setViewName("permission-list");
//       return mv;
//    }


    @RequestMapping("/save.do")
    public String savePermission(Permission permission) throws Exception {
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteById.do")
    public String deletePermissionById(String id) throws Exception
    {
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }
}
