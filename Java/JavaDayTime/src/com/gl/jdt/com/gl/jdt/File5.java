package com.gl.jdt;

import java.time.LocalDate;

public class File5 {
    public static void main(String[] args) {
        LocalDate d1 =LocalDate.of(2025,11,21);
        LocalDate d2 = LocalDate.of(2025,11,21);
        if(d1.isAfter(d2)){
            System.out.println("D1 is after d2");
        }
        else if(d1.isBefore(d2)){
            System.out.println("d1 is before d2");
        }
        else{
            System.out.println("Both dates are Same");
        }
    }

}
