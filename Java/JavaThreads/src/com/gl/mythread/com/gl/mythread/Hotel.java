package com.gl.mythread;

public class Hotel {
    public static void main(String[] args) {
        Elevator sharedElevator = new Elevator();

        // Creating 3 luggage threads using the shared elevator
        Luggage l1 = new Luggage(1, 5, sharedElevator, "Luggage1");
        Luggage l2 = new Luggage(3, 7, sharedElevator, "Luggage2");
        Luggage l3 = new Luggage(2, 9, sharedElevator, "Luggage3");

        // Start threads
        l1.start();
        l2.start();
        l3.start();

    }

}
