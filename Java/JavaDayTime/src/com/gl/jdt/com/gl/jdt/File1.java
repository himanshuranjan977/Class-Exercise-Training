package com.gl.jdt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class File1 {

    public static void main(String[] args) {
        Date date =new Date();
        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localtime = LocalTime.now();
        System.out.println(localtime);
    }

}
