package com.example.scheduler.controllers;


import com.example.scheduler.models.User;
import com.example.scheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {

        System.out.println("/all");
        return userService.getAllUsers();
    }

    @PostMapping("/add")
        public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {
           return ResponseEntity.ok(userService.addUser(new User(user.getUsername(),user.getFirstName(),user.getPassword())));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("user couldn't be saved");
        }
    }



    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username).get();
       return  user;
    }
}
