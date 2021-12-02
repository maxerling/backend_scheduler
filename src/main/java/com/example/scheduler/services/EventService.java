package com.example.scheduler.services;


import com.example.scheduler.expection.OverlappingInfoException;
import com.example.scheduler.models.Event;
import com.example.scheduler.models.User;
import com.example.scheduler.repositories.EventRepository;
import com.example.scheduler.repositories.UserRepository;
import com.example.scheduler.util.DateFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Iterable<Event> getAllBookedAppointments() {
        return eventRepository.findAll();
    }
    public Event saveEvent(Event event) {

        User user = userRepository.findById(event.getUser().getId()).orElseThrow(() -> new RuntimeException("user not found"));;
        System.out.println("user: " + user);
        event.setUser(user);
        System.out.println("event " + event);

        List<Event> eventsThatDate = getEventsBasedOnDate(event.getDate());
        List<Event> overlappingEvents = calculateOverlappingEvents(event,eventsThatDate);
        if (overlappingEvents.size() > 0) {
            throw new OverlappingInfoException("Overlapping date & time, try agin!");
        }


        Event savedEvent = eventRepository.save(event);
        System.out.println("savedEvent " + savedEvent);
        return savedEvent;
    }

    public List<Event> getEventsBasedOnDate(String date) {
        return eventRepository.getEventsByDate(date);
    }

    public List<Event> calculateOverlappingEvents(Event newEvent , List<Event> listOfEventsSameDate) {
        List<Event> overlappingEvents = new ArrayList<>();
        if (listOfEventsSameDate.size() > 0) {
            DateFormater dateFormater = new DateFormater("HH:mm");
            Date addEventStartTime = dateFormater.formatTimeStringToTimeDate(newEvent.getStartTime());
            Date addEventStopTime = dateFormater.formatTimeStringToTimeDate(newEvent.getEndTime());
            listOfEventsSameDate.forEach(e -> {
                Date eventSameDateStartTime = dateFormater.formatTimeStringToTimeDate(e.getStartTime());
                Date eventSameDateStopTime = dateFormater.formatTimeStringToTimeDate(e.getEndTime());
                if ( (addEventStartTime.before(eventSameDateStopTime) || addEventStartTime.getTime() == eventSameDateStopTime.getTime()) && (eventSameDateStartTime.before(addEventStopTime) || eventSameDateStartTime.getTime() == addEventStopTime.getTime()))
                { overlappingEvents.add(e);
                };

            });

            return overlappingEvents;
        }
        return listOfEventsSameDate;
    }
}
