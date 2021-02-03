package com.boyang.myflix.service.impl;

import com.boyang.myflix.bean.Category;
import com.boyang.myflix.repository.CategoryRepository;
import com.boyang.myflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String addCategory(Category category) {
        return categoryRepository.save(category).getId();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
