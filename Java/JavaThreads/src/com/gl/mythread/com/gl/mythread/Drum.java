package com.gl.mythread;

public class Drum extends Thread {
    String name;
    int beatCount;

    public Drum(String name, int beatCount) {
        this.name = name;
        this.beatCount = beatCount;
    }
    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void run() {
        try {
            for (int i = 1; i <= beatCount; i++) {
                System.out.println(name + " beat " + i);

                if (Thread.currentThread().getName().equalsIgnoreCase("Cat") && i == 10) {
                    throw new RuntimeException("Crashing the drum 3 at 10");
                }

                Thread.sleep(50); // optional, just to make output clearer
            }
        } catch (Exception ex) {
            System.out.println("Exception caught in " + name + ": " + ex.getMessage());
       }
    }




}
