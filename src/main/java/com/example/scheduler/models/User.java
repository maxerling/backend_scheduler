package com.example.scheduler.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {


    static final boolean DEFAULT_ENABLED = true;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(referencedColumnName ="id"))
    private List<Authority> authorities;
    private boolean enabled;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Event> bookedAppointments;


    public User(String username, String firstName,String password, List<Authority> authorities, boolean enabled) {
        if (authorities.size() == 0 ) {
            authorities.add(new Authority("ROLE_USER","role user"));
        }
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.bookedAppointments = new ArrayList<>();
        this.firstName = firstName;
    }

    public User(String username, String firstName, String password) {
        this(username,firstName,password,new ArrayList<>(),DEFAULT_ENABLED);
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

    public String getFirstName() {
        return firstName;
    }
}
