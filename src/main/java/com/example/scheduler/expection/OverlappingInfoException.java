package com.example.scheduler.expection;

public class OverlappingInfoException extends IllegalArgumentException{

    public OverlappingInfoException(String msg) {
        super(msg);
    }
}
