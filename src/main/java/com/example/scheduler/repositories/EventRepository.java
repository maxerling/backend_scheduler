package com.example.scheduler.repositories;

import com.example.scheduler.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
//    @Query(value = "SELECT * FROM event e WHERE e.date=?1",
//            nativeQuery = true)
    List<Event> getEventsByDate(String date);


}
