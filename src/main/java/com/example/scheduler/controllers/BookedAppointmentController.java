package com.example.scheduler.controllers;


import com.example.scheduler.models.BookedAppointment;
import com.example.scheduler.models.User;
import com.example.scheduler.services.BookedAppointmentService;
import com.example.scheduler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class BookedAppointmentController {

    @Autowired
    private BookedAppointmentService bookedAppointmentService;

    @GetMapping("/all")
    public Iterable<BookedAppointment> getAllBookedAppointments() {
        return bookedAppointmentService.getAllBookedAppointments();
    }
}
