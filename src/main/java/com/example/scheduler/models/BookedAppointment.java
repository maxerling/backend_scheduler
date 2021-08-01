package com.example.scheduler.models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "booked_appointments")
public class BookedAppointment {

    public BookedAppointment() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @OneToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;


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


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
