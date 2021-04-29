package com.kuang.service;

import com.kuang.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll() throws Exception;
}
