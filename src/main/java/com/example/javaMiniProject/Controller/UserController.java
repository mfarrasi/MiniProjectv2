package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<User> create (@RequestBody User request) {
        User response = request;

        response = userService.createUser(request);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/getuser")
    public ResponseEntity<User> getUser (@RequestParam String param) {
        User response = new User();

        response = userService.getUser(param);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User request) {
        User response = new User();

        //get user date
        response = userService.updateUser(request);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteUser (@RequestParam String param) {
        User response = new User();

        response = userService.deleteUser(param);

        return ResponseEntity.ok(response);
    }
}
