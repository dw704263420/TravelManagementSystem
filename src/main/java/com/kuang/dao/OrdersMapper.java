package com.kuang.dao;

import com.kuang.pojo.Orders;

import java.util.List;

/**
 * 订单相关查询
 */
public interface OrdersMapper {
    public List<Orders> findAll() throws Exception;
    public Orders findById(String orderId) throws  Exception;
}
