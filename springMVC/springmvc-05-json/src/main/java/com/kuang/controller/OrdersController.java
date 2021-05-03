package com.kuang.controller;


import com.github.pagehelper.PageInfo;
import com.kuang.pojo.Orders;
import com.kuang.pojo.Traveller;
import com.kuang.pojo.TravellerModel;
import com.kuang.service.OrdersService;
import com.kuang.service.TravellerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    @Autowired
    @Qualifier("TravellerServiceImpl")
    private TravellerService travellerService;

    /**
     * 管理员查看所有订单列表
     * @param model
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @RequestMapping("/findAll.do")
    public String findAll(Model model, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "10")int size) throws Exception {
        List<Orders> all = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(all); // 这本身就是一个分页bean，可以看看里面的源码
        model.addAttribute("pageInfo",pageInfo);
        // 分页之后，数据不止原来的实体类，还有页码信息 当前多少条信息 是第几条到第几
        // 条信息等
        return  "orders-page-list";
    }

    /**
     * 管理员查看订单详情
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @GetMapping("/findById.do")
    public String ordersFindById(@RequestParam(name = "id" ,required = true) String id,Model model) throws Exception {
        Orders orders = ordersService.findById(id);
        System.out.println(orders);
        model.addAttribute("orders",orders);
        return "orders-show";
    }


//    @PostMapping("/submitOrder")
//    public String submitOrder(TravellerModel travellers,@RequestParam("uid") String uid, int productId, Model model) throws Exception {   // 获取页面传来的多个参数
//        List<Traveller> travellers1 = travellers.getTravellers();
//        for (Traveller traveller : travellers1) {
//            // 逐个添加，如果之前没有 现在就会添加
//            travellerService.addTraveller(traveller);
//        }
//        int peopleCount = travellers1.size();
//
//        // 创建订单，并且订单链接这些旅客
//        Orders orders = ordersService.addOrder(peopleCount, productId, uid);
//        // 链接订单与旅客
//        ordersService.addOrderWithTravellers(travellers1,orders);
//
//        model.addAttribute("peopleCount", peopleCount);
//        model.addAttribute("uid", uid);
//        model.addAttribute("productId", productId);
//
//        return "user_pay_page";
//    }

    /**
     * 提交订单，包含订单的产品ID，游者顾客的信息
     * @param travellerType
     * @param name
     * @param sex
     * @param phoneNum
     * @param credentialsType
     * @param credentialsNum
     * @param model
     * @param uid
     * @param productId
     * @return
     * @throws Exception
     */
    @PostMapping("/submitOrder2")
    public String submitOrder2(Integer [] travellerType,String [] name,String [] sex,String []phoneNum,Integer [] credentialsType,String []credentialsNum,Model model,String uid, int productId) throws Exception {

        int len= travellerType.length;
        List<Traveller> travellerList = new ArrayList<Traveller>();
        for (int i = 0; i < len; i++) {
            Traveller traveller = new Traveller(name[i], sex[i], phoneNum[i], credentialsType[i], credentialsNum[i], travellerType[i]);
            travellerList.add(traveller);
        }
        System.out.println(travellerList);
        int peopleCount = travellerList.size();

        // 创建订单，并且订单链接这些旅客
        Orders orders = ordersService.addOrder(peopleCount, productId, uid);
        // 链接订单与旅客
        ordersService.addOrderWithTravellers(travellerList,orders);

        model.addAttribute("peopleCount", peopleCount);
        model.addAttribute("uid", uid);
        model.addAttribute("productId", productId);
        model.addAttribute("order",orders);
        return "user_pay_page";

    }

    /**
     * 到达支付页面
     * @param orderNum
     * @param payType
     * @param model
     * @return
     */
    @PostMapping("/toPay")
    public String toPag(String orderNum,String payType,Model model)
    {   model.addAttribute("orderNum",orderNum);
        model.addAttribute("payType",payType);
        return "pay-page";
    }

    /**
     * 接受前台支付完订单的请求
     * @param orderNum
     * @param payType
     * @return
     */
    @PostMapping("/payFinished")
    public  String toPayFinish(String orderNum,String payType){

        ordersService.payFinished(orderNum,payType);
        return "pay-finish";
    }
    @GetMapping("/MyOrder")
    public String myOrder(String uid,Model model)
    {
        List<Orders> orders = ordersService.findOrderByUserId(uid);
        model.addAttribute("orderList",orders);
        return "my-order";
    }
    @GetMapping("findUserOrder")
    public String myOrderDetail(@RequestParam("orderId")String orderId,Model model) throws Exception {
        Orders byId = ordersService.findById(orderId);
        model.addAttribute("orders",byId);
        return "my-order-detail";

    }

}
