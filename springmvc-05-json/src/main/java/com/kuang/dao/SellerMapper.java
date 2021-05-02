package com.kuang.dao;

import com.kuang.pojo.Seller;

/**
 * 卖家相关查询
 */
public interface SellerMapper {
    public Seller findSellerBySid(int sid) throws Exception;
}
