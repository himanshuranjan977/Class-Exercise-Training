package com.gl.error;

import com.sun.jdi.AbsentInformationException;

public class Sample2 {
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
    public void devide3(int a ,int b) {
        if(b==0){
            throw new ArithmeticException("Please dont try to divide by Zero ");
        }
        System.out.println(" Q : " + (a/b));
    }

    public static void main(String[] args) throws AbsentInformationException {
        Sample2 s1= new Sample2();
        try {
            s1.devide3(25, 0);
        } catch (ArithmeticException ex) {
            System.out.println("Error " + ex.getMessage());

        }
    }

}
