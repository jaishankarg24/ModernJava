package com.learn.java.dates;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

// 9
public class DatetoLocalDateExample {

	public static void main(String[] args) {
        /**
         *  java.util.Date to LocalDate and vice versa
         */

        Date date = new Date();
        System.out.println("converted Local Date : "+ date.toInstant().atZone(ZoneId.of("America/Chicago")).toLocalDate());

        LocalDate localDate = LocalDate.now();
        Date date1 = new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("java.util.date is : " + date1);


        /**
         *  LocalDate to java.sql.Date
         */

        java.sql.Date date2 = java.sql.Date.valueOf(localDate);
        System.out.println("java.sql.date is : " + date2);


        LocalDate localDate2 = date2.toLocalDate();
        System.out.println("converted Local Date : " + localDate2);

	}

}
/*
converted Local Date : 2023-02-11
java.util.date is : Sun Feb 12 03:01:15 IST 2023
java.sql.date is : 2023-02-12
converted Local Date : 2023-02-12

*/