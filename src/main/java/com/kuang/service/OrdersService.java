package com.kuang.service;

import com.kuang.pojo.Orders;

import java.util.List;

public interface OrdersService {
    public Orders findById(String orderId) throws Exception;
    List<Orders> findAll(int size,int page) throws Exception;
}
