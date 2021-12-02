package com.example.scheduler.services;

import com.example.scheduler.models.Authority;
import com.example.scheduler.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;


    public List<Authority> getAllRoles() {
        return (List<Authority>) authorityRepository.findAll();
    }
    public Authority addRole(Authority authority) {
        return authorityRepository.save(authority);
    }
}
