package com.gl.mythread;

public class Theatre extends Thread {
    String movieName;
    int movieLength;
    public Theatre(String movieName, int movieLength) {
        this.movieName = movieName;
        this.movieLength = movieLength;
    }

    @Override
    public void run() {
        System.out.println("Starting movie: " + movieName + " | Length: " + movieLength + " mins");

        for (int i = 1; i <= movieLength; i++) {
            try {
                System.out.println(movieName + " running minute: " + i);

                // If movie time reaches 50 mins, sleep for 10 seconds
                if (i == 50) {
                    System.out.println(movieName + " paused at 50 mins... sleeping for 10 seconds");
                    Thread.sleep(10000); // 10 seconds
                    System.out.println(movieName + " resumed after sleep");
                }

                Thread.sleep(200); // Simulating each minute (speeded up)

            } catch (InterruptedException e) {
                System.out.println(movieName + " interrupted.");
            }
        }

        System.out.println(movieName + " finished.");
    }
}







