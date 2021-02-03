package com.boyang.myflix.controller;

import com.boyang.myflix.bean.Category;
import com.boyang.myflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.findAll();
    }
}
