package com.gl.jdt;

import java.time.LocalDate;
import java.time.Period;

public class File4 {
    public static void main(String[] args) {
        LocalDate currenDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2002,9,8);
        Period age =Period.between(birthDate,currenDate);
        System.out.println("My Age is " + age.getYears() + " years " + age.getMonths() + " months " + age.getDays() +" days");
    }

}
