package com.learn.java.dates;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

// 8
public class ZonedDateTimeExample {

	public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); //gets you this machines TimeZone
        System.out.println("zonedDateTime : " + zonedDateTime);

        ZoneOffset zoneOffset = zonedDateTime.getOffset();
        System.out.println("zoneOffset : " + zoneOffset);

        ZoneId zoneId = zonedDateTime.getZone();
        System.out.println("zoneId : " + zoneId.getId());

        // System.out.println("getAvailableZoneIds : " + ZoneId.getAvailableZoneIds());

        /*ZoneId.getAvailableZoneIds()
                .forEach(zone -> {
                    System.out.println("zone : " + zone);
                });*/
        System.out.println("no Of Zones : " + ZoneId.getAvailableZoneIds().size());


        //America/Chicago
        //America/Detroit
        //America/Los_Angeles
        //America/Phoenix

        /**
         * Times in each zone
         */
        System.out.println("Chicago CST     : " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("Detroit EST     : " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("LA PST : "  + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println("Denver MST     : "  + ZonedDateTime.now(ZoneId.of("America/Denver")));

        /**
         *
         */
        System.out.println("ZonedDate Time using Clock : "
                + ZonedDateTime.now(Clock.system(ZoneId.of("America/Denver"))));


        /**
         * Local Date time using Zone Id.
         */
        System.out.println("Current Time of the Machine CST: " + LocalDateTime.now());

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Detroit"));
        System.out.println("Detroit : " + localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now(Clock.system(ZoneId.of("America/Detroit")));
        System.out.println("Detroit : " + localDateTime1);

        /**
         * LocalDateTime using Instant
         */
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("Instant LocalDate time :" +localDateTime2);


        /**
         * Convert LocalDateTime to ZonedDateTime
         */
        ZonedDateTime  zonedDateTime1 = localDateTime.atZone(ZoneId.of("America/Chicago"));
        System.out.println("LocalDateTime to Zoned : " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Chicago"));
        System.out.println("Instant to Zoned : " + zonedDateTime2);

        /**
         * Convert LocalDateTime to OffsetDateTime
         */
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("offsetDateTime : " + offsetDateTime);

	}

}
/*
zonedDateTime : 2023-02-12T02:57:42.123+05:30[Asia/Calcutta]
zoneOffset : +05:30
zoneId : Asia/Calcutta
no Of Zones : 601
Chicago CST     : 2023-02-11T15:27:42.131-06:00[America/Chicago]
Detroit EST     : 2023-02-11T16:27:42.162-05:00[America/Detroit]
LA PST : 2023-02-11T13:27:42.164-08:00[America/Los_Angeles]
Denver MST     : 2023-02-11T14:27:42.165-07:00[America/Denver]
ZonedDate Time using Clock : 2023-02-11T14:27:42.165-07:00[America/Denver]
Current Time of the Machine CST: 2023-02-12T02:57:42.165
Detroit : 2023-02-11T16:27:42.165
Detroit : 2023-02-11T16:27:42.165
Instant LocalDate time :2023-02-12T02:57:42.165
LocalDateTime to Zoned : 2023-02-11T16:27:42.165-06:00[America/Chicago]
Instant to Zoned : 2023-02-11T15:27:42.166-06:00[America/Chicago]
offsetDateTime : 2023-02-11T16:27:42.165-06:00
*/