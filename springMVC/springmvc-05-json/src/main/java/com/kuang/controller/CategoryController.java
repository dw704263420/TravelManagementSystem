package com.kuang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.Category;
import com.kuang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类别相关Controler
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;

    /**
     * 响应头部组件-门票-酒店-那些
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/findAll")
    public String findAllCategory() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Category> categoryList = categoryService.findAll();
        return mapper.writeValueAsString(categoryList);

    }
}
