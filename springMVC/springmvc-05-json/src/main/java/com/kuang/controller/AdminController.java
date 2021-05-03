package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员相关Controler
 */
@Controller
public class AdminController {

    // 登录入口
    @RequestMapping("/admin")
    public String admin()
    {
        return "login";
    }


}
