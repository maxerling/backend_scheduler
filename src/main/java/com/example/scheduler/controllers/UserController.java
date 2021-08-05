package com.example.scheduler.controllers;


import com.example.scheduler.models.User;
import com.example.scheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/auth")
    public void auth() {

    }

//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String role) {
//        return ResponseEntity.ok(userService.addUser(username, password, role));
//    }
}
