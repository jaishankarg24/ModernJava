package com.learn.java.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

// 2
public class LocalDateExample {


    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("Current Date is " + localDate);

        LocalDate localDate1 = LocalDate.of(2018, 03,03);
        System.out.println(localDate1);

        System.out.println("Year Day Date " + LocalDate.ofYearDay(2023,365));

        //System.out.println("Epoch Day " + LocalDate.ofEpochDay(1));


        /**
         * Getting Values from Local Date
         */
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getYear());
        System.out.println("Day of Month using get : " + localDate.get(ChronoField.DAY_OF_MONTH));

        /**
         * Modifying Values in Local Date
         */
        System.out.println("Plus Weeks  : " + localDate.plusWeeks(1));
        System.out.println("Plus Years : " + localDate.plusYears(1));
        System.out.println("Plus Days " + localDate.plusDays(1));
        System.out.println("Plus Months : " + localDate.plusMonths(1));
        System.out.println("Minus Months : "+localDate.minusMonths(1));
        System.out.println("Chrono Unit : " + localDate.minus(2, ChronoUnit.YEARS));
        System.out.println("With Year : " + localDate.withYear(2019));
        System.out.println("With Year Chrono Field : " + localDate.with(ChronoField.YEAR , 2019));
        System.out.println("With Temporal Adjusters : " + localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("With Temporal Adjusters : " + localDate.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.FRIDAY))); // maps to the first friday of the week

        /**
         * Unsupported Scenarios
         */
        //  System.out.println("Chrono Unit : " + localDate.minus(2, ChronoUnit.SECONDS));
        System.out.println("is Supported : " + localDate.isSupported(ChronoUnit.DAYS));

        /**
         * Additional Support Methods
         */
        System.out.println("Not a Leap Year : " + localDate.isLeapYear());
        LocalDate  localDate2 = LocalDate.of(2020,01,31);
        System.out.println("Leap Year : " +  localDate2.isLeapYear());

        System.out.println("isBefore : " + localDate1.isBefore(localDate));
        System.out.println("isAfter : " + localDate1.isAfter(localDate));
        System.out.println("isEqual : " + localDate1.isEqual(localDate));

    }

}
/*
Current Date is 2023-02-12
2018-03-03
Year Day Date 2018-12-31
FEBRUARY
2
SUNDAY
43
2023
Day of Month using get : 12
Plus Weeks  : 2023-02-19
Plus Years : 2024-02-12
Plus Days 2023-02-13
Plus Months : 2023-03-12
Minus Months : 2023-01-12
Chrono Unit : 2021-02-12
With Year : 2019-02-12
With Year Chrono Field : 2019-02-12
With Temporal Adjusters : 2023-02-28
With Temporal Adjusters : 2023-02-03
is Supported : true
Not a Leap Year : false
Leap Year : true
isBefore : true
isAfter : false
isEqual : false
*/