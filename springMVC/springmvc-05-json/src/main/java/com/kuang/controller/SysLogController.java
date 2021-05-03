package com.kuang.controller;

import com.github.pagehelper.PageInfo;
import com.kuang.pojo.SysLog;
import com.kuang.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 操作日志相关Controler
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    @Qualifier("SysServiceImpl")
    private  SysService sysService;

    @RequestMapping("/findAll.do")
    public String findAll(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "10")int size) throws Exception {

        List<SysLog> sysLogList=sysService.findAll(page, size);
        PageInfo sysLogs = new PageInfo(sysLogList); // 这本身就是一个分页bean，可以看看里面的源码
        model.addAttribute("sysLogs",sysLogs);
        return "syslog-list";
    }
    @PostMapping("/queryForUserName.do")
    public String queryForUserName(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "10")int size,String userName) throws Exception
    {
        if ("".equals(userName)|| userName==null)
        {
            return "redirect:findAll.do";
        }

        List<SysLog> sysLogList = sysService.queryForUserName(userName, page, size);
        PageInfo sysLogs = new PageInfo(sysLogList); // 这本身就是一个分页bean，可以看看里面的源码
        model.addAttribute("sysLogs",sysLogs);
        return "syslog-list";


    }
    @GetMapping("/deleteSysLog.do")
    public String deleteAllSysLog()
    {
        sysService.deleteAllSysLog();
        return "redirect:findAll.do";
    }
}
