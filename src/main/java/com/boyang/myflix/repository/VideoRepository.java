package com.boyang.myflix.repository;

import com.boyang.myflix.bean.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VideoRepository extends MongoRepository<Video, String> {
    List<Video> findAllByCategories(String category);
}
