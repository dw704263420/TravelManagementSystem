package com.kuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.kuang.dao.ProductMapper;
import com.kuang.pojo.Product;
import com.kuang.service.ProductService;

import java.util.HashMap;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return productMapper.findAll();
    }

    @Override
    public int saveProduct(Product product) throws Exception {
        return  productMapper.saveProduct(product);
    }

    @Override
    public int updateProduct(Product product) throws Exception {
        return productMapper.updateProduct(product);
    }

    @Override
    public Product findProductById(int id) throws Exception {
        return productMapper.findProductById(id);
    }

    @Override
    public int delById(int id) throws Exception {
        return productMapper.delById(id);
    }

    @Override
    public List<Product> findAllByWords(int page, int size, String keyWord,int cid) throws Exception {
        PageHelper.startPage(page,size);
        return productMapper.findAllByWords(keyWord,cid);

    }

    @Override
    public Product findProdectDetail(int id) throws Exception {
        return productMapper.findProdectDetail(id);
    }

    @Override
    public List<Product> findProductByUserFavourite(List<Integer> favoList) throws Exception {
        HashMap hashMap= new HashMap();
        hashMap.put("favoMap",favoList);
        List<Product> productByUserFavourite = productMapper.findProductByUserFavourite(hashMap);
        return productByUserFavourite;
    }

    @Override
    public List<Product> findProductByRand(int num) throws Exception {
        return productMapper.findProductByRand(num);
    }
}
