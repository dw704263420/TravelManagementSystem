package com.kuang.dao;

import com.kuang.pojo.Traveller;

import java.util.List;

/**
 * 旅游者相关查询
 */
public interface TravellersMapper {
    public List<Traveller> findTraverllersByOrderId(String orderId) throws Exception;
    public void addTraveller(Traveller traveller) throws Exception;
    public Traveller findTravellerByIdentifyCard(String idCard) throws Exception; //根据身份证照号码区分唯一旅客

}
