package com.kuang.service;

import com.kuang.pojo.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> findAllBanner();
    public  void deleteById(String  bid);
    public  void addOneBanner(Banner banner);
}
