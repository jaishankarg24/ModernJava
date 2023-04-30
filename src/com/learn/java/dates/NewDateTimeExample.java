package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 1
public class NewDateTimeExample {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate : "+ localDate);
        
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime : "+ localTime);
        
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime : "+ localDateTime);
    }

}
/*
localDate : 2023-02-12
localTime : 02:32:16.326
localDateTime : 2023-02-12T02:32:16.327
*/