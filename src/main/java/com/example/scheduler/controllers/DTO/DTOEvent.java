package com.example.scheduler.controllers.DTO;

public class DTOEvent {
    private Long id;
    private String name;
    private String description;
    private String start_time;
    private String end_time;
    private String date;

    public DTOEvent(Long id, String name, String description, String start_time, String end_time, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
    }

    public DTOEvent() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDate() {
        return date;
    }
}
