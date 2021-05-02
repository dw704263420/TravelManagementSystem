package com.kuang.dao;

import com.kuang.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 订单相关查询
 */
public interface OrdersMapper {
    public List<Orders> findAll() throws Exception;
    public Orders findById(String orderId) throws  Exception;
    public void addOrder(Orders orders)throws Exception;
    public Orders findOrderByOrderNum(String orderNum) throws Exception;
    public void connectOrderAndTraveller(@Param("orderId") String orderId, @Param("travellerId") String travellerId);
    void payFinished(@Param("orderNum") String orderNum, @Param("payType") String payType);
    List< Orders > findOrderByUserId(String uid);
}
