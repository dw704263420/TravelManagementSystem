package com.kuang.dao;

import com.kuang.pojo.Category;

import java.util.List;

/**
 * 分类相关查询
 */
public interface CategoryMapper {
    public List<Category> findAll() throws Exception;

    String findCnameByCid(int cid);
}
