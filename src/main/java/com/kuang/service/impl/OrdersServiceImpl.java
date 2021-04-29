package com.kuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.OrdersMapper;
import com.kuang.pojo.Orders;
import com.kuang.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    private OrdersMapper ordersMapper;

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public Orders findById(String orderId) throws Exception {
        return ordersMapper.findById(orderId);
    }

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //第一个参数 页码 第二个参数 每页查询条数
        PageHelper.startPage(page,size);
      return ordersMapper.findAll();
    }
}
