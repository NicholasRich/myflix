package com.boyang.myflix.service.impl;

import com.boyang.myflix.bean.User;
import com.boyang.myflix.repository.UserRepository;
import com.boyang.myflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(User user) {
        return userRepository.save(user).getId();
    }
}
