package com.kuang.dao;

import com.kuang.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品相关查询
 */
public interface ProductMapper {

    public List<Product> findAll() throws Exception ;
    public int saveProduct(Product product) throws Exception;
    public int updateProduct(Product product) throws Exception;
    public Product findProductById(@Param("id")int id) throws Exception;
    public int delById(@Param("id")int id) throws Exception;
    List<Product> findAllByWords(@Param("keyWord") String keyWord,@Param("cid") int cid);
    Product findProdectDetail(int id) throws Exception;
    List<Product> findProductByUserFavourite(Map map) throws Exception;
    List<Product> findProductByRand(int num) throws Exception;
}
