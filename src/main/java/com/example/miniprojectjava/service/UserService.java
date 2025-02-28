package com.example.miniprojectjava.service;

import com.example.miniprojectjava.entity.User;
import com.example.miniprojectjava.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User request) {
        User response = request;

        userRepository.save(response);
        return response;
    }
}
