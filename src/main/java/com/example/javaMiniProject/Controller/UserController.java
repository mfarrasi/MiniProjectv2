package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PutMapping("/updateuser")
    public String updateUser(
            @RequestParam Integer userId,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {
        return userService.updateUser(userId, username,email, password);
    }
}
