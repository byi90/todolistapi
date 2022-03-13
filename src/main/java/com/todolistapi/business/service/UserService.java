package com.todolistapi.business.service;

import com.todolistapi.data.entity.User;
import com.todolistapi.data.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String userEmail){
        return getUserRepository().findByEmail(userEmail);
    }

    public void saveUser(User user){
        getUserRepository().save(user);
    }




    public UserRepository getUserRepository() {
        return userRepository;
    }
}
