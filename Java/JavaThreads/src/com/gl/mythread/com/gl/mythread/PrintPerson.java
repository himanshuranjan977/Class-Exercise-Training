package com.gl.mythread;

public class PrintPerson {
    public static void main(String[] args) {
        Sharedprinter offSharedprinter=new Sharedprinter();
        PrintTask task1 =new PrintTask(offSharedprinter, "My First Document", 10);
        PrintTask task2 =new PrintTask(offSharedprinter, "My Second Document", 20);
       
task1.start();
task2.start();
    }

}
