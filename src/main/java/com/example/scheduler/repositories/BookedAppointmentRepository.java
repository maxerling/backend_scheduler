package com.example.scheduler.repositories;

import com.example.scheduler.models.BookedAppointment;
import org.springframework.data.repository.CrudRepository;

public interface BookedAppointmentRepository extends CrudRepository<BookedAppointment,Long> {
}
