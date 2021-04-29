package com.kuang.dao;

import com.kuang.pojo.Traveller;

import java.util.List;

/**
 * 旅游者相关查询
 */
public interface TravellersMapper {
    public List<Traveller> findTraverllersByOrderId(String orderId) throws Exception;
}
