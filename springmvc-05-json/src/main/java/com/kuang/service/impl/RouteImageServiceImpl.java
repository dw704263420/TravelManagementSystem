package com.kuang.service.impl;

import com.kuang.dao.RouteImgMapper;
import com.kuang.pojo.RouteImg;
import com.kuang.service.RouteImageService;

public class RouteImageServiceImpl implements RouteImageService {
    private RouteImgMapper routeImgMapper;

    public void setRouteImgMapper(RouteImgMapper routeImgMapper) {
        this.routeImgMapper = routeImgMapper;
    }

    @Override
    public void addRoouteImage(RouteImg routeImg) {
        routeImgMapper.addRouteImage(routeImg);
    }

    @Override
    public void deleteById(String rgid) {
        routeImgMapper.deleteById(rgid);
    }

    @Override
    public void changeProductCover(String rImage, String productId) {
        routeImgMapper.changeProductCover(rImage,productId);
    }
}
