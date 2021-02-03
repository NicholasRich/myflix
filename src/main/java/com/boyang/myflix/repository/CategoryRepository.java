package com.boyang.myflix.repository;

import com.boyang.myflix.bean.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
