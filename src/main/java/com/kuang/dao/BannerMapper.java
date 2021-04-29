package com.kuang.dao;

import com.kuang.pojo.Banner;

import java.util.List;

/**
 * 轮播图相关查询
 */
public interface BannerMapper {
    public List<Banner> findAllBanner() ;
}
