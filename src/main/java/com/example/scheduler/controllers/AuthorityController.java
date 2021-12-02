package com.example.scheduler.controllers;

import com.example.scheduler.models.Authority;
import com.example.scheduler.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/roles/")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;


    @GetMapping("/all")
    public Iterable<Authority> getAllRoles() {
        return authorityService.getAllRoles();
    }

    @PostMapping("/add")
    public String addRole(@RequestBody Authority authority) {
        System.out.println("!! " + authority);
        String response = "ok";
       Authority savedAuthority = authorityService.addRole(authority);
       if (savedAuthority == null) {
           response = "something went wrong";
       }
       return response;
    }
}
