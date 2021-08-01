package com.example.scheduler.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//@Table(name = "schedule")
public class Schedule {

    public Schedule() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    private String start_time;
    private String end_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
