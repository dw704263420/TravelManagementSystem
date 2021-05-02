package com.kuang.service;

import com.kuang.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(int page,int size) throws Exception;
    public int saveProduct(Product product) throws  Exception;
    public int updateProduct(Product product) throws Exception;
    public Product findProductById(@Param("id")int id) throws Exception;
    public int delById(@Param("id")int id) throws Exception;
    List<Product> findAllByWords(int page, int size, String keyWord,int cid) throws Exception;
    Product findProdectDetail(int id)throws Exception;
    List<Product> findProductByUserFavourite(List<Integer> favoList) throws Exception;
    List<Product> findProductByRand(int num) throws Exception;
}
