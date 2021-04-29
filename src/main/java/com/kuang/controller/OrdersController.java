package com.kuang.controller;


import com.github.pagehelper.PageInfo;
import com.kuang.pojo.Orders;
import com.kuang.service.OrdersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 订单相关Controler
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    @Qualifier("OrdersServiceImpl")
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public String findAll(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
        List<Orders> all = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(all); // 这本身就是一个分页bean，可以看看里面的源码
        model.addAttribute("pageInfo",pageInfo);
        // 分页之后，数据不止原来的实体类，还有页码信息 当前多少条信息 是第几条到第几
        // 条信息等
        return  "orders-page-list";
    }

    @GetMapping("/findById.do")
    public String ordersFindById(@RequestParam(name = "id" ,required = true) String id,Model model) throws Exception {
        Orders orders = ordersService.findById(id);
        System.out.println(orders);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
}
