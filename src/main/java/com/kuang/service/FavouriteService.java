package com.kuang.service;

import com.kuang.pojo.Favourite;

import java.util.List;

public interface FavouriteService {
    public Integer findProductFavouriteTimes(int productId) throws Exception;
    public boolean findUserIsFavourite(int uid, int productId);
    public boolean changeFavourite(int id,int productId) throws Exception;
    List<Integer> findUserFavouriteProId(int uid) throws Exception;

    List<Integer> findUserFavouriteTopId(int num) throws Exception;
}
