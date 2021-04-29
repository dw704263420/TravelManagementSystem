package com.kuang.controller;

import com.github.pagehelper.PageInfo;
import com.kuang.pojo.SysLog;
import com.kuang.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findAll(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {

        List<SysLog> sysLogList=sysService.findAll(page, size);
        for (SysLog sysLog : sysLogList) {

            System.out.println(sysLog);
        }
        PageInfo sysLogs = new PageInfo(sysLogList); // 这本身就是一个分页bean，可以看看里面的源码
        model.addAttribute("sysLogs",sysLogs);
        return "syslog-list";
    }
}
