package com.kuang.controller;


import com.kuang.pojo.Banner;
import com.kuang.pojo.Product;
import com.kuang.service.BannerService;
import com.kuang.service.FavouriteService;
import com.kuang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页相关Controler
 */
@Controller
public class IndexController {
    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;
    @Autowired
    @Qualifier("FavouriteServiceImpl")
    private FavouriteService favouriteService;
    @Autowired
    @Qualifier("BannerServiceImpl")
    private BannerService bannerService;

    @RequestMapping("forIndex")
    public String forIndex(Model model) throws Exception {
        // 取前4个人气高的产品放到首页
        List<Integer> userFavouriteTopId = favouriteService.findUserFavouriteTopId(4);
        if (userFavouriteTopId.size()>0)
        {
            List<Product> productByUserFavourite = productService.findProductByUserFavourite(userFavouriteTopId);
            model.addAttribute("recomProduct",productByUserFavourite);
        }
        // 加载轮播图
        List<Banner> bannerList = bannerService.findAllBanner();
        model.addAttribute("bannerList",bannerList);

        // 加载随心推荐 加载8条吧
        List<Product> recomProduct = productService.findProductByRand(6);
        model.addAttribute("randProduct",recomProduct);

        return  "user_index";
    }




}
