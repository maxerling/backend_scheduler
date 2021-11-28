package com.example.scheduler.controllers;


import com.example.scheduler.expection.OverlappingInfoException;
import com.example.scheduler.models.Event;
import com.example.scheduler.services.EventService;
import com.example.scheduler.util.DateFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public Iterable<Event> getAllBookedAppointments() {
        return eventService.getAllBookedAppointments();
    }

    @GetMapping("")
    public Iterable<Event> getEventsBasedOnDate(@RequestParam String date) {
        return eventService.getEventsBasedOnDate(date);
    }


    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {

        Event addedEvent = eventService.saveEvent(event);
        return new ResponseEntity<>(addedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deletedEvent() {

        return "event was deleted";
    }



}
