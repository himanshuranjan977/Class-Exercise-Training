package com.gl.jdt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class File2 {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY  HH:mm");
        
        //DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm");
        String newFormat = currentTime.format(myFormat);
        System.out.println(newFormat);
    }

}
