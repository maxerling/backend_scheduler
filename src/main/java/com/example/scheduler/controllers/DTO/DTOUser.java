package com.example.scheduler.controllers.DTO;

public class DTOUser {
    private Long id;
    private String username;

    public DTOUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public DTOUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
