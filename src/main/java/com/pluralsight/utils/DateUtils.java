package com.pluralsight.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String currentTime(){ //used to get current, local time when making a new transaction
        LocalDateTime timeRightNow = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss"); //formatted as shown in capstone example
        String currentTime = timeRightNow.format(fmt);

       return currentTime; //returns current, local time
    }
    public static String currentDate(){ //used to get current, local date when making a new transaction
        LocalDateTime todaysDate = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //formatted as shown in capstone example
        String currentDate = todaysDate.format(dateFormat);

       return currentDate; //returns current, local date
    }
}
