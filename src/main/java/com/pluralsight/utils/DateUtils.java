package com.pluralsight.utils;

/*
Useful for:

date parsing
comparing dates
determining current month/year

Especially helpful for report filtering.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String currentTime(){
        LocalDateTime timeRightNow = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss"); //correct format
        String currentTime = timeRightNow.format(fmt);

       return currentTime;
    }
    public static String currentDate(){
        LocalDateTime todaysDate = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = todaysDate.format(dateFormat);
       return currentDate;
    }
}
