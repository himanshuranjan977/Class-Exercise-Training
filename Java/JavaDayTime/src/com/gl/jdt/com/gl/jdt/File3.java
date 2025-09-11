package com.gl.jdt;

import java.time.LocalDate;

public class File3 {
    public static void main(String[] args) {
        LocalDate today =LocalDate.now();
        LocalDate functions = today.plusDays(3);
        LocalDate function = today.plusWeeks(3);
        LocalDate functio = today.minusDays(5);
        System.out.println(functio);
        System.out.println(function);
        System.out.println(functions);
    }

}
