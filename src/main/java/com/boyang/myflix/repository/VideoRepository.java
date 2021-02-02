package com.boyang.myflix.repository;

import com.boyang.myflix.bean.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
