package com.learn.java.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExample {

	public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime :" + localDateTime);
        LocalDateTime localDateTime1  = LocalDateTime.of(2018, 01,01,12,10,00);
        System.out.println("localDateTime1 : " + localDateTime1);

        /**
         * Getting the Values
         */
        System.out.println("getMinute : " + localDateTime.getMinute());
        System.out.println("getHour : " + localDateTime.getHour());
        System.out.println("DAY_OF_MONTH : " + localDateTime.get(ChronoField.DAY_OF_MONTH));

        /**
         *  Modifying the values in Local Time
         */
        System.out.println("plusDays : " + localDateTime.plusDays(2));
        System.out.println("minusDays : " + localDateTime.minusDays(2));
        System.out.println("withMonth : " + localDateTime.withMonth(2));
        System.out.println("with : " + localDateTime.with(ChronoField.MONTH_OF_YEAR,3));
        System.out.println("firstDayOfNextMonth : " + localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));



        /**
         * Converting LocalDate,LocalTime to LocalDateTime and vice versa
         */

        LocalDate localDate = LocalDate.now();
        System.out.println("atTime : "+ localDate.atTime(23,30)); //another way LocalDate.of()

        LocalTime localTime = LocalTime.now();
        System.out.println("atTime : "+ localTime.atDate(localDate));
        System.out.println("atStartOfDay : " + localDate.atStartOfDay());

        System.out.println("toLocalDate : " + localDateTime.toLocalDate());
        System.out.println("toLocalTime : " + localDateTime.toLocalTime());



	}

}

/*
localDateTime :2023-02-12T02:42:31.577
localDateTime1 : 2018-01-01T12:10
getMinute : 42
getHour : 2
DAY_OF_MONTH : 12
plusDays : 2023-02-14T02:42:31.577
minusDays : 2023-02-10T02:42:31.577
withMonth : 2023-02-12T02:42:31.577
with : 2023-03-12T02:42:31.577
firstDayOfNextMonth : 2023-03-01T02:42:31.577
atTime : 2023-02-12T23:30
atTime : 2023-02-12T02:42:31.596
atStartOfDay : 2023-02-12T00:00
toLocalDate : 2023-02-12
toLocalTime : 02:42:31.577
*/