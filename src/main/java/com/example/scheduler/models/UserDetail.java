//package com.example.scheduler.models;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//public class UserDetail implements UserDetails {
//    private String username;
//    private String password;
//    private List<Authority> authorities;
//    private boolean active;
//
//    public UserDetail(User user)  {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.authorities = user.getAuthorities();
//        this.active = user.isActive();
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return active;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return active;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return active;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
//
//
//}
