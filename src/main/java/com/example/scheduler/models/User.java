package com.example.scheduler.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(referencedColumnName ="id"))
    private List<Authority> authorities;
    private boolean enabled;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Event> bookedAppointments;


    public User(String username, String password, String firstName, String lastName, List<Authority> authorities, boolean enabled) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public User() {}




    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Event> getBookedAppointments() {
        return bookedAppointments;
    }

    public void setBookedAppointments(List<Event> bookedAppointments) {
        this.bookedAppointments = bookedAppointments;
    }

    public String getUsername() {
        return username;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
