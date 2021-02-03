package com.boyang.myflix.repository;

import com.boyang.myflix.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
