package com.gl.mythread;

public class Elevator {
     public synchronized void move(int from, int to, String luggageName) {
        System.out.println(luggageName + " entering elevator at floor " + from);
        try {
            Thread.sleep(1000); // simulate elevator travel time
        } catch (InterruptedException e) {
            System.out.println("Elevator interrupted for " + luggageName);
        }
        System.out.println(luggageName + " exiting elevator at floor "+to);
    }


}
