package com.learn.java.dates;

import java.time.LocalDate;
import java.time.Period;

// 5
public class ComparingDatesPeriodExample {

	public static void main(String[] args) {
        LocalDate  localDate = LocalDate.of(2018,01,01);
        LocalDate  localDate1 = LocalDate.of(2018,12,31);

        /**
         * until - Period
         */
        Period period = localDate.until(localDate1);
        System.out.println("getDays : " + period.getDays()); // results in 30 days performs (31-1)
        System.out.println("getMonths : " + period.getMonths()); // results in 0 days (12-01)

        Period period1 = Period.ofDays(10);
        System.out.println("getDays : " + period1.getDays());
        Period period2 = Period.ofYears(20);
        System.out.println("getYears : " + period2.getYears());
        System.out.println("toTotalMonths : " + period2.toTotalMonths());
        System.out.println("getDays : " + period2.getDays());



        Period period3 = Period.between(localDate, localDate1);
        System.out.println("getDays : " +period3.getDays());
        System.out.println("getMonths : " +period3.getMonths());
        System.out.println("getYears : " +period3.getYears());
	}

}
/*
getDays : 30
getMonths : 11
getDays : 10
getYears : 20
toTotalMonths : 240
getDays : 0
getDays : 30
getMonths : 11
getYears : 0


Introduction to Optional
• Introduced as part of Java 8 to represent a Non-Null value 
• Avoids Null Pointer Exception and Unnecessary Null Checks. 
• Inspired from the new languages such as scala , groovy etc.,

Default and Static Methods in Interfaces
Interfaces in Java - Prior Java 8:
• Define the contract. 
• Only allowed to declare the method. Not allowed to implement 
a method in Interface. 
• Implementation is only allowed in the Implementation class. 
• Not easy for an interface to evolve.

Default Methods – Java 8
• default keyword is used to identify a default method in an interface.
Example from List Interface:
default void sort(Comparator<? super E> c) { Object[] a = this.toArray();
 Arrays.sort(a, (Comparator) c);
 ListIterator<E> i = this.listIterator(); for (Object e : a) { i.next();
 i.set((E) e);
 }
}
• Prior to Java 8 we normally use Collections.sort() to perform the similar 
operation.
• Can be overridden in the Implementation class.
• Used to evolve the Interfaces in Java.

Static Methods – Java 8
• Similar to default methods. 
• This cannot be overridden by the implementation classes.

Abstract Classes vs Interfaces in Java 8
• Instance variables are not allowed in Interfaces. 
• A class can extend only one class but a class can implement 
multiple interfaces.

Does this enable Multiple Inheritance in 
Java?
• Yes 
• This was never possible before Java 8.


Introduction to New Date/Time 
Libraries

• LocalDate, LocalTime and LocalDateTime and part of the java.time package. 
• These new classes are created with the inspiration from the JodaTime library. 
• All the new time libraries are Immutable. 
• Supporting classes like Instant, Duration,Period and etc. 
• Date, Calendar prior to Java 8.
LocalDate: Used to represent the date.
LocalTime: Used to represent the time. 
LocalDateTime: Used to represent the date and time.


Period:
• Period is a date-based representation of time in Days , Months and Years and is part of the java.time package.
• Compatible with LocalDate.
• It represents a Period of Time not just a specific date and time.
Example:
Period period1 = Period.ofDays(10); // represents a Period of 10 days
Period period2 = Period.ofYears(20); // represents a Period of 20 years

Period : Use-Case
• Mainly used calculate the difference between the two 
dates. 
Example: 
LocalDate localDate = LocalDate.of(2018,01,01);
LocalDate localDate1 = LocalDate.of(2018,01,31); 
Period period = Period.between(localDate,localDate1); // calculates the difference 
between the two dates


Duration
• A time based representation of time in hours , 
minutes, seconds and nanoseconds. 
• Compatible with LocalTime and LocalDateTime 
• It represents a duration of time not just a specific 
time. 
Example: 
Duration duration1 = Duration.ofHours(3);; // represents the duration of 3 hours 
Duration duration1 = Duration. ofMinutes(3); // represents the duration of 3 minutes

Duration : Use-Case
• It can be used to calculate the difference between the time 
objects such as LocalTime and LocalDateTime. 
Example: 
LocalTime localTime = LocalTime.of(7,20);
LocalTime localTime1 = LocalTime.of(8,20); 
Duration duration = Duration.between(localTime,localTime1);


Instant:
• Represent the time in a machine readable format. 
Example: 
Instant ins = Instant.now(); 
- Represents the time in seconds from January 01,1970(EPOCH)
to current time as a huge number.


Time Zones
• ZonedDateTime, ZoneID, ZoneOffset 
• ZonedDateTime - Represents the date/time with its time 
zone. 
Example: 
2018-07-18T08:04:14.541-05:00[America/Chicago] 
ZoneOffset-> -05:00 
ZoneId -> America/Chicago


DateTimeFormatter
• Introduced in Java 8 and part of the java.time.format
package. 
• Used to parse and format the LocalDate, LocalTime and 
LocalDateTime.
Parse and Format
• parse - Converting a String to a LocalDate/LocalTime/

LocalDateTime. 
• format - Converting a LocalDate/LocalTime/LocalDateTime to 
a String
*/