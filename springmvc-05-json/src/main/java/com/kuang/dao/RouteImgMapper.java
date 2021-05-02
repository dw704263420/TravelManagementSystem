package com.kuang.dao;

import com.kuang.pojo.RouteImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品图片相关查询
 */
public interface RouteImgMapper{
    public List<RouteImg> findProductImg(int id) throws Exception;
    public void addRouteImage(RouteImg routeImg);

    public void deleteById(String rgid);
    public void  changeProductCover(@Param("rImage") String rImage, @Param("productId") String productId);
}
