package com.kuang.service.impl;

import com.kuang.dao.TravellersMapper;
import com.kuang.pojo.Traveller;
import com.kuang.service.TravellerService;

public class TravellerServiceImpl implements TravellerService {
    private TravellersMapper travellersMapper;

    public void setTravellersMapper(TravellersMapper travellersMapper) {
        this.travellersMapper = travellersMapper;
    }

    @Override
    public void addTraveller(Traveller traveller) throws Exception {
        Traveller exist = travellersMapper.findTravellerByIdentifyCard(traveller.getCredentialsNum());
        if (exist!=null)
        {
            // 说明之前已经存在该用户了 那么就不用再重复存了
            return;
        }else
        {
            travellersMapper.addTraveller(traveller);
        }
    }

    @Override
    public Traveller findTravellerByIdentifyCard(String idCard) throws Exception {
        // 找到id为idCard的一个旅客
        return travellersMapper.findTravellerByIdentifyCard(idCard);
    }
}
