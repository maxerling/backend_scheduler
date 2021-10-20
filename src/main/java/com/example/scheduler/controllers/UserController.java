package com.example.scheduler.controllers;


import com.example.scheduler.models.User;
import com.example.scheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username).get();
        System.out.println(user);
       return  user;
    }

//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String role) {
//        User newUser = new User();
//        newUser.setUsername(username);
//        newUser.setPassword(password);
//        newUser.setRole(role);
//        return ResponseEntity.ok(userService.addUser(newUser));
//    }
}
