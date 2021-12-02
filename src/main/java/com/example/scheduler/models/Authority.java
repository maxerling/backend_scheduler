package com.example.scheduler.models;

import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority implements GrantedAuthority {

    public Authority(String roleCode, String roleDescription) {
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleCode;
    private String roleDescription;
    @ManyToMany(mappedBy = "authority", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Authority() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }


    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';

    }
}


