package com.example.scheduler;

import com.example.scheduler.models.Authority;
import com.example.scheduler.models.User;
import com.example.scheduler.repositories.UserRepository;
import com.example.scheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);

    }


    @Autowired
    private UserService userService;

    @PostConstruct
    protected void init() {
        List<Authority> authorities = new ArrayList<>();


        authorities.add(new Authority("ROLE_USER","role user"));
        authorities.add(new Authority("ROLE_ADMIN","role admin"));
        User user = new User();
        //user.setId(10L);
        user.setUsername("user1"); 
        user.setPassword("user1");
        user.setFirstName("Ash");
        user.setLastName("Ketchum");
        user.setAuthorities(authorities);
        user.setEnabled(true);
        //userService.addUser(user);
    }

}



