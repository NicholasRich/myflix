package com.boyang.myflix.service;

import com.boyang.myflix.bean.Category;

import java.util.List;

public interface CategoryService {
    String addCategory(Category category);

    List<Category> findAll();
}
