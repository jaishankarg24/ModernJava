package com.learn.java.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// 3
public class LocalTimeExample {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(23,33);
        System.out.println(localTime1);

        LocalTime localTime2 = LocalTime.of(22,33,45);
        System.out.println(localTime2);

        /**
         * Getting the values from LocalTime
         */
        System.out.println("Hours " + localTime.getHour());
        System.out.println("Second " + localTime.getSecond());
        System.out.println("Using Get " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println("toSecondOfDay : "+ localTime.toSecondOfDay());

        /**
         * Modifying the values in Local Time
         */
        System.out.println("modify hours : " + localTime.minusHours(2));
        System.out.println("modify hours using chronoUnit: " + localTime.minus(2,ChronoUnit.HOURS));
        System.out.println("modify using with : " + localTime.with(LocalTime.MIDNIGHT));
        System.out.println("modify using with chrono field: " + localTime.with(ChronoField.HOUR_OF_DAY,22));
        System.out.println("modify hours : " + localTime.plus(2, ChronoUnit.MINUTES));
        System.out.println("modify withHour : " + localTime.withHour(2));

    }

}
/*
02:40:49.670
23:33
22:33:45
Hours 2
Second 49
Using Get 2
toSecondOfDay : 9649
modify hours : 00:40:49.670
modify hours using chronoUnit: 00:40:49.670
modify using with : 00:00
modify using with chrono field: 22:40:49.670
modify hours : 02:42:49.670
modify withHour : 02:40:49.670
*/