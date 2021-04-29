package com.kuang.service.impl;

import com.kuang.dao.BannerMapper;
import com.kuang.pojo.Banner;
import com.kuang.service.BannerService;

import java.util.List;

public class BannerServiceImpl implements BannerService {

    private BannerMapper bannerMapper;

    public void setBannerMapper(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<Banner> findAllBanner() {
        return bannerMapper.findAllBanner();
    }
}
