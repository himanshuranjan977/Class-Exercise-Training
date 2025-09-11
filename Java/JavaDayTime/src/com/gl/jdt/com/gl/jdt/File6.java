package com.gl.jdt;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class File6 {
    public static void main(String[] args) {
        ZonedDateTime europeTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(europeTime.format(myFormat));
        System.out.println(indiaTime.format(myFormat));
    }

}
