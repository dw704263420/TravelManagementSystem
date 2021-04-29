package com.kuang.dao;

import com.kuang.pojo.RouteImg;

import java.util.List;

/**
 * 产品图片相关查询
 */
public interface RouteImgMapper{
    public List<RouteImg> findProductImg(int id) throws Exception;
}
