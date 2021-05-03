package com.kuang.dao;

import com.kuang.pojo.Favourite;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 收藏相关查询
 */
public interface FavouriteMapper {
    public Integer findProductFavouriteTimes(int productId) throws Exception;
    public Favourite findUserIsFavourite(@Param("uid")int uid,@Param("productId")int productId);
    void deleteFavourite(@Param("uid")int uid,@Param("productId")int productId) throws Exception;
    void appendFavourite(@Param("uid")int uid,@Param("productId")int productId,@Param("date") Date date) throws Exception;
    List<Integer> findUserFavouriteProId(int uid) throws Exception;
    List<Integer> findUserFavouriteTopId(int num) throws Exception;
}
