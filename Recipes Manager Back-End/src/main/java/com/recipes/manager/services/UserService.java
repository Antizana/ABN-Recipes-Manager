package com.recipes.manager.services;

import com.recipes.manager.entities.User;
import com.recipes.manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String username,String password){
        return userRepository.authenticateUser(username,password);
    }

    public User addNewUser(User user){
        return userRepository.save(user);
    }
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
