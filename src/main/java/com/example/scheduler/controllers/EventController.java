package com.example.scheduler.controllers;


import com.example.scheduler.models.Event;
import com.example.scheduler.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/events")
@CrossOrigin(origins = "*")
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
