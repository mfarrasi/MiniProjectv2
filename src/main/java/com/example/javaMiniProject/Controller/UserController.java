package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PutMapping("/updateuser")
    public ResponseEntity<User> updateUser(
            @RequestParam Integer userId,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {
        User response = new User();
        response = userService.updateUser(userId, username,email, password);
        if (response.getRc().equals("0000")){
            return ResponseEntity.status(200).body(response);
        }else {
            return ResponseEntity.status(404).body(response);
        }
    }
}
