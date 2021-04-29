package com.kuang.service.impl;

import com.kuang.dao.FavouriteMapper;
import com.kuang.pojo.Favourite;
import com.kuang.service.FavouriteService;

import java.util.Date;
import java.util.List;

public class FavouriteServiceImpl implements FavouriteService {
    private FavouriteMapper favouriteMapper;

    public void setFavouriteMapper(FavouriteMapper favouriteMapper) {
        this.favouriteMapper = favouriteMapper;
    }

    @Override
    public Integer findProductFavouriteTimes(int productId) throws Exception {
        return favouriteMapper.findProductFavouriteTimes(productId);
    }

    @Override
    public boolean findUserIsFavourite(int uid, int productId) {
        Favourite userIsFavourite = favouriteMapper.findUserIsFavourite(uid, productId);
        if(userIsFavourite!=null)
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean changeFavourite(int id,int productId) throws Exception {
        boolean flag ;
        Favourite userIsFavourite = favouriteMapper.findUserIsFavourite(id, productId);
        if (userIsFavourite!=null)
        {
            flag = true;
        }else
        {
            flag = false;
        }
        if (flag == true)
        {
            favouriteMapper.deleteFavourite(id,productId);
        }else
        {
            favouriteMapper.appendFavourite(id,productId,new Date());
        }
        return !flag;
    }

    @Override
    public List<Integer> findUserFavouriteProId(int uid) throws Exception {
       return favouriteMapper.findUserFavouriteProId(uid);
    }

    @Override
    public List<Integer> findUserFavouriteTopId(int num) throws Exception {

        return favouriteMapper.findUserFavouriteTopId(num);
    }
}
