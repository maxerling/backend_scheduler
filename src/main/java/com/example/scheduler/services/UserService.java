package com.example.scheduler.services;

import com.example.scheduler.models.Authority;
import com.example.scheduler.models.User;
import com.example.scheduler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    public Iterable<User> getAllUsers() {
        Iterable<User>  allUsers = userRepository.findAll();
        System.out.println(allUsers);
       return allUsers;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        List<Authority> roles = new ArrayList<>();
        roles.add(authorityService.getRole("ROLE_USER"));
        user.setAuthorities(roles);
        return userRepository.save(user);
    }





}
