package com.kuang.service.impl;

import com.kuang.dao.CategoryMapper;
import com.kuang.pojo.Category;
import com.kuang.service.CategoryService;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl  implements CategoryService {
    private CategoryMapper categoryMapper;

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() throws Exception {
        // 使用redis 来进行优化缓存
        Jedis jedis = new Jedis();
        // 查询redis中是否有该项 若有则不用从数据库中查
        Set<String> category = jedis.zrange("category",0,-1);
        List<Category> all = null;
        if(category == null || category.size()==0)
        {
            all = categoryMapper.findAll();
            //存入到redis中的category的key 的
            for (Category category1 : all) {
                jedis.zadd("category",category1.getCid(),category1.getCname());
            }
//            jedis.zadd("category",)
        }else{
            // 如果不为空，则将set的数据返回赋值给list数据返回
            all = new ArrayList<Category>();
            for (String name : category) {
                Category category1 = new Category();
                category1.setCname(name);
                all.add(category1);
            }

        }
        return all;

    }
}
