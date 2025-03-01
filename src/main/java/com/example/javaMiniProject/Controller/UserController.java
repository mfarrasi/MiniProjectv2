package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() { return userService.getAllUser();}

    @GetMapping("/getUser")
    public User getUserById(int id) { return userService.getUserById(id);}

    @PostMapping("/createUser")
    public ResponseEntity<User> create (@RequestBody User request) {
        User response = request;

        response = userService.createUser(request);

        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return userService.login(username, password);
    }
}
