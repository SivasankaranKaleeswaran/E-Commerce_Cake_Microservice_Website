package com.ecom.microservice.user.service;

import com.ecom.microservice.user.UserRepository;
import com.ecom.microservice.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
       var createdUser = userRepository.save(user);
       return createdUser;
    }
}
