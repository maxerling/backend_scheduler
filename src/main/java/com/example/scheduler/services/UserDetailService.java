package com.example.scheduler.services;

import com.example.scheduler.models.User;
import com.example.scheduler.models.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<User> user = userService.getUserByUsername(username);
         user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

         return new UserDetail(user.get());

    }

}
