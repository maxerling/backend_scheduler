package com.example.scheduler.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
    private String pattern;

    public DateFormater( String pattern) {

        this.pattern = pattern;
    }

    public Date formatTimeStringToTimeDate(String time) {
        Date formattedDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            formattedDate = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formattedDate;

    }


}
