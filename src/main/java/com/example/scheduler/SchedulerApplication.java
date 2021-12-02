package com.example.scheduler;

import com.example.scheduler.models.Authority;
import com.example.scheduler.models.User;
import com.example.scheduler.repositories.UserRepository;
import com.example.scheduler.services.AuthorityService;
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
    private AuthorityService authorityService;

    @PostConstruct
    protected void init() {
        authorityService.addRole(new Authority("ROLE_USER","role user"));
        authorityService.addRole(new Authority("ROLE_ADMIN","role admin"));
    }

}



