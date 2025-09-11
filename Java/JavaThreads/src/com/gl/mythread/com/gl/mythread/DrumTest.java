package com.gl.mythread;

public class DrumTest {
    public static void main(String[] args) {
        Drum drum1 = new Drum("Drum 1", 50);
        Drum drum2 = new Drum("Drum 2", 50);
        Drum drum3 = new Drum("Drum 3", 50);

        drum1.setName("Lion");
        drum2.setName("Tiger");
        drum3.setName("Cat");

        // Optionally set priority
        // drum1.setPriority(1);
        // drum2.setPriority(10);

        drum1.start();
        drum2.start();
        drum3.start();

    }

}
