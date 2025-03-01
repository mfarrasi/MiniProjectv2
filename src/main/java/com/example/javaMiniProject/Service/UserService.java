package com.example.javaMiniProject.Service;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User updateUser(Integer userId, String username, String email, String password) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            User response = new User();
            response.setRc("0005");
            response.setRcDesc("User not found!");
            return response;
        }

        User user = optionalUser.get();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRc("0000");
        user.setRcDesc("Success");
        userRepository.save(user);

        return user;
    }
}
