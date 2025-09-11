package com.gl.error;

import com.sun.jdi.AbsentInformationException;

public class Sample1 {
    public void divide(int a,int b){
        try {
            System.out.println("Q : " + (a/b));
        } catch ( ArithmeticException e) {
            System.out.println("Cannot divide by Zero ");
        }

    }
    public void devide2(int a ,int b) throws AbsentInformationException{
        System.out.println(" Q : " + (a/b));
    }

    public static void main(String[] args) throws AbsentInformationException {
        Sample1 s1= new Sample1();
        try {
            s1.devide2(25, 0);
        } catch (ArithmeticException ex) {
            System.out.println("Devide by 0 error");

        }
    }

}
