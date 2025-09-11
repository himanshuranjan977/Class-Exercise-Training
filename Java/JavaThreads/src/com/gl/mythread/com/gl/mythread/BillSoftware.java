package com.gl.mythread;

public class BillSoftware {

    public static void main(String[] args) {
        Communication2 sms = new Communication2("sms", "Bill sent via SMS", 3);
        Communication2 print = new Communication2("print", "Printing bill...", 2);

        sms.start();
        print.start();

    }
}
