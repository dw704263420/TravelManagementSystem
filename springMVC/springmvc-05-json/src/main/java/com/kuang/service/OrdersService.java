package com.kuang.service;

import com.kuang.pojo.Orders;
import com.kuang.pojo.Traveller;

import java.util.List;

public interface OrdersService {
    public Orders findById(String orderId) throws Exception;
    List<Orders> findAll(int size,int page) throws Exception;
    public Orders addOrder(int peopleCount,int productId,String uid) throws Exception;

    void addOrderWithTravellers(List<Traveller> travellers, Orders orders) throws Exception;

    void payFinished(String orderNum, String payType);

    List<Orders> findOrderByUserId(String uid);

}
