package com.kuang.service;

import com.kuang.pojo.RouteImg;
import org.apache.ibatis.annotations.Param;

public interface RouteImageService {
    public void addRoouteImage(RouteImg routeImg);

    public void deleteById(String rgid);
    public void changeProductCover(String rImage, String productId);
}
