package com.kuang.service;

import com.kuang.pojo.Traveller;

public interface TravellerService {
    public void addTraveller(Traveller traveller) throws Exception;
    public Traveller findTravellerByIdentifyCard(String idCard) throws Exception; //根据身份证照号码区分唯一旅客
}
