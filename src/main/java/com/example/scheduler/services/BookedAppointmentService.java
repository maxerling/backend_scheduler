package com.example.scheduler.services;


import com.example.scheduler.models.BookedAppointment;
import com.example.scheduler.repositories.BookedAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookedAppointmentService {

    @Autowired
    private BookedAppointmentRepository bookedAppointmentRepository;

    public Iterable<BookedAppointment> getAllBookedAppointments() {
        return bookedAppointmentRepository.findAll();
    }
}
